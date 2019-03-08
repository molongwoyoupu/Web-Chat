package com.ssm.manage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.common.pojo.DataResult;
import com.ssm.common.pojo.ResResult;
import com.ssm.common.utils.CookieUtils;
import com.ssm.common.utils.JsonUtils;
import com.ssm.common.utils.RandomUtils;
import com.ssm.im.pojo.ChatMessage;
import com.ssm.manage.mapper.UserMapper;
import com.ssm.manage.pojo.User;
import com.ssm.manage.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Value("${USER_TOKEN_KEY}")
	private String USER_TOKEN_KEY;
	@Value("${SESSION_EXPIRE_TIME}")
	private Integer SESSION_EXPIRE_TIME;

	@Override
	public DataResult getUserList(int page, int rows) {
		// 查询之前,配置分页
		PageHelper.startPage(page, rows);
		// 进行查询
		List<User> list = userMapper.getAllUsers();
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		// 返回结果
		DataResult dataResult = new DataResult();
		dataResult.setRows(list);
		dataResult.setTotal(pageInfo.getTotal());
		return dataResult;
	}

	@Override
	public void saveUserList() {
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setAccountNum(RandomUtils.getUUID());
			user.setNickName(RandomUtils.getRandomChar(3));
			user.setHeadPath(getHeadPath((int) (Math.random() * 4 + 1)));
			user.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
			user.setGender("" + (int) (Math.random() * 1 + 1));
			user.setAge("" + (int) (Math.random() * 9 + 15));
			user.setCreateTime(new Date());
			userList.add(user);
		}
		userMapper.insertUserList(userList);
	}
	private String getHeadPath(int i) {
		String str="";
		switch (i) {
		case 1:
			str="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg";
			break;
		case 2:
			str="http://k2.jsqq.net/uploads/allimg/17091443/17-1F9140920430-L.jpg";
			break;
		case 3:
			str="http://k2.jsqq.net/uploads/allimg/17092551/17-1F925092U10-L.jpg";
			break;
		case 4:
			str="http://k2.jsqq.net/uploads/allimg/17090924/17-1FZ9105R40-L.jpg";
			break;
		case 5:
			str="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg";
			break;
			
		default:
			break;
		}
		return str;
	}
	// 用户登录
	@Override
	public ResResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		User searchUser=new User();
		searchUser.setAccountNum(username);
		List<User> list = userMapper.selectByUser(searchUser);
		// 如果没有该用户名
		if (null == list || list.size() == 0) {
			return ResResult.build(400, "用户名或密码错误");
		}
		User user = list.get(0);
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(
				user.getPassword())) {
			return ResResult.build(400, "用户名或密码错误");
		}
		// 生成token
		String token = UUID.randomUUID().toString();
		// 把用户信息写入session
		user.setPassword(null);
		request.getSession().setAttribute(USER_TOKEN_KEY + ":" + token, JsonUtils.objectToJson(user));
		// 设置过期时间
		request.getSession().setMaxInactiveInterval(SESSION_EXPIRE_TIME);
		// 添加写cookie的逻辑，cookie的有效期是关闭浏览器失效
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);

		return ResResult.ok(token);
	}

	//根据token取用户信息
	@Override
	public ResResult getUserByToken(String token,
			HttpServletRequest request, HttpServletResponse response) {

		// 根据token从session中查询用户信息
		Object json = request.getSession().getAttribute(USER_TOKEN_KEY + ":" + token);
		if (StringUtils.isEmpty(json)) {
			return ResResult.build(400, "会话过期，请重新登录");
		}
		// 更新过期时间
		request.getSession().setMaxInactiveInterval(SESSION_EXPIRE_TIME);
		// 返回用户信息
		return ResResult.ok(JsonUtils.jsonToPojo(json.toString(), User.class));
	}

	// 退出登录
	@Override
	public ResResult userLogout(String token,
			HttpServletRequest request, HttpServletResponse response) {
		// 根据token从redis删除用户信息
		request.getSession().removeAttribute(USER_TOKEN_KEY + ":" + token);
		// 返回用户信息
		return ResResult.ok();
	}

	@Override
	public String getUserListBySearch(int page, int rows, User user) {
		// 查询之前,配置分页
		PageHelper.startPage(page, rows);
		// 进行查询
		List<User> list = userMapper.selectByUser(user);
		
		// 返回结果
		return JsonUtils.objectToJson(list);
	}

	@Override
	public User getThisOnLineUser(HttpServletRequest request) {
		String token=CookieUtils.getCookieValue(request,"TT_TOKEN");
		// 根据token从session中查询用户信息
		Object json = request.getSession().getAttribute(USER_TOKEN_KEY + ":" + token);
		if (StringUtils.isEmpty(json)) {
			throw new RuntimeException("会话过期，请重新登录");
		}
		User user=JsonUtils.jsonToPojo(json.toString(), User.class);
		return user;
	}
}
