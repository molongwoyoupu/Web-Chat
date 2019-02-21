package com.ssm.common.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResResult implements Serializable{

	// 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
	private static final long serialVersionUID = 1212793578786477332L;

	private Integer status;
	
	private String msg;
	
	// 响应中的数据
    private Object data;
    
    public ResResult() {

    }

    public ResResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }
    
    public ResResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ResResult ok() {
        return new ResResult(null);
    }
    
    public static ResResult ok(Object data) {
        return new ResResult(data);
    }
    
    public static ResResult build(Integer status, String msg) {
        return new ResResult(status, msg, null);
    }
	
    public static ResResult build(Integer status, String msg, Object data) {
        return new ResResult(status, msg, data);
    }

    
    /**
     * 将json结果集转化为ResResult对象
     * 
     * @param jsonData json数据
     * @param clazz ResResult中的object类型
     * @return
     */
    public static ResResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ResResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    public static ResResult format(String json) {
        try {
            return MAPPER.readValue(json, ResResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static ResResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
