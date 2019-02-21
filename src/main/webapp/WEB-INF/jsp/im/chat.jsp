<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web即时通讯</title>
<style>
    .chat-container{width:800px;height:600px;margin:auto;margin-top:30px;box-shadow: 2px 2px 50px #ccc, -2px -2px 50px #ccc;z-index:99999;}
    .friend-area{width:250px;height:600px;float:left;overflow: auto;background:rgb(207,207,207)}
    .chat-window{height:600px;width:550px;margin-left:250px;}
    .msg-list-area{height:370px;overflow: auto;padding:5px;padding-bottom:40px;}
    .msg-add-area{position:relative;height:104px;}
    button#btnSend{position: absolute;right:10px;bottom:10px;}
    textarea#chat{width:100%;height:100%;padding:5px;}
    .friend-item{padding:10px 15px;height:60px;margin-bottom:1px;}
    .friend-item-avatar{width:60px;height:60px;border-radius:50%;float:left;}
    .friend-item-name{margin-left:8px;display:inline-block;vertical-align:middle;height:100%;padding-top:20px;}
    .msg-item{margin-top:15px;}
    .msg-item-friend-avatar{width:40px;height:40px;border-radius:50%;}
    .avatar-user .msg-item-friend-avatar{float:left;}
    .avatar-me .msg-item-friend-avatar{float:right;}
    .avatar-user .msg-item-right{margin-left:48px;}
    .avatar-me .msg-item-right{margin-right:48px;}
    .msg-item-right-name{font-size: 14px;color:#333;}
    .msg-item-send-time{font-size:13px;}
    .avatar-me .msg-item-send-time{text-align: right;}
    .msg-item-right-content{font-size:13px;background:rgb(209,209,209);padding:8px 15px;border-radius:5px;display:inline-block;}
    .avatar-user .msg-item-right-content{margin-right:100px;}
    .avatar-me .msg-item-right-content{margin-left:100px;}
    .avatar-me .msg-item-right-name{text-align: right;}
    .avatar-me .msg-item-right-content{text-aligin:right;background:rgb(82,172,101);color:white;text-align: right;display:inline-block;float:right;}
</style>
</head>
<body>
    <div class="chat-container">
        <div class="friend-area">
            <div class="friend-item" style="background:#eee;">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg"/>
                <span class="friend-item-name">张三</span>
                <div style="clear:both;"></div>
            </div>
            <div class="friend-item">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17091443/17-1F9140920430-L.jpg"/>
                <span class="friend-item-name">张三</span>
                <div style="clear:both;"></div>
            </div>
            <div class="friend-item">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17092551/17-1F925092U10-L.jpg"/>
                <span class="friend-item-name">张三</span>
                <div style="clear:both;"></div>
            </div>
            <div class="friend-item">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17090924/17-1FZ9105R40-L.jpg"/>
                <span class="friend-item-name">张三</span>
                <div style="clear:both;"></div>
            </div>
            <div class="friend-item">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg"/>
                <span class="friend-item-name">张三</span>
                <div style="clear:both;"></div>
            </div>
        </div>
        <div class="chat-window">
            <div class="friend-info" style="background:rgb(231,231,231);">
                <div class="friend-item">
                    <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg"/>
                    <span class="friend-item-name">李五</span>
                    <div style="clear:both;"></div>
                </div>
            </div>
            <div id="msgList" class="msg-list-area">
<!--                <div class="msg-item avatar-user">
                    <img class="msg-item-friend-avatar" src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2182925329,386985427&fm=27&gp=0.jpg">
                    <div class="msg-item-right"> 
                        <div class="msg-item-right-name">李五</div>
                        <div class="msg-item-send-time">2017-10-17 09:08:11</div>
                        <div class="msg-item-right-content" >在吗？lionel</div>
                        <div style="clear:both;"></div>
                    </div>
                </div> -->
                <!-- <div class="msg-item avatar-me">
                    <img class="msg-item-friend-avatar" src="http://img5.imgtn.bdimg.com/it/u=1822899106,40471411&fm=27&gp=0.jpg">
                    <div class="msg-item-right"> 
                        <div class="msg-item-right-name">lionel</div>
                        <div class="msg-item-send-time">2017-10-17 09:08:11</div>
                        <div class="msg-item-right-content">你大撒发撒发fddasjkfjkdsajkfkjew大撒发空间撒附近发苏打粉绝对看撒辣椒；看风景额外前锋杰我靠前峰武器；看风景委屈分看委屈乏味气氛李；委屈分看了我穷家富路科技武器兰科维奇快乐；飞机我企鹅快乐；将的撒肌肤抵抗撒；的撒看见疯狂悄然过去将开启企鹅给我企鹅个前峰武器个高考前国务卿</div>
                    </div>
                </div> -->
            </div>
            <div class="msg-add-area">
                <textarea id="chat" rows="5" cols="30"></textarea>
                <button id="btnSend">发送</button>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
    var userid = new Date().valueOf();

    var Chat = {};

    var obj = null;

    Chat.socket = null;

    Chat.connect = (function(host) {
        if ('WebSocket' in window) {
            Chat.socket = new WebSocket(host);
        } else if ('MozWebSocket' in window) {
            Chat.socket = new MozWebSocket(host);
        } else {
            //Console.log('Error: WebSocket is not supported by this browser.');
            return;
        }

        Chat.socket.onopen = function() {
            // Console.log('Info: WebSocket connection opened.');
            document.getElementById('chat').onkeydown = function(event) {
                if (event.keyCode == 13) {
                    Chat.sendMessage();
                }
            };
        };

        Chat.socket.onclose = function() {
            document.getElementById('chat').onkeydown = null;
            //Console.log('Info: WebSocket closed.');
        };

        Chat.socket.onmessage = function(message) {
            var html = $("#msgList").html() + '<div class="msg-item avatar-user"><img class="msg-item-friend-avatar" src="http://img5.imgtn.bdimg.com/it/u=1822899106,40471411&fm=27&gp=0.jpg"><div class="msg-item-right"><div class="msg-item-right-name">lionel</div><div class="msg-item-send-time">'+getNowFormatDate()+'</div><div class="msg-item-right-content">'+message.data+'</div><div style="clear:both;"></div></div></div>';
            $("#msgList").html(html);
        };
    });

    Chat.initialize = function() {
        if (window.location.protocol == 'http:') {
            Chat.connect('ws://localhost:8080/websocket/' + userid);
        } else {
            Chat.connect('wss://localhost:8080/websocket/' + userid);
        }
    };

    Chat.close = function() {
        Chat.socket.onclose();
    };

    Chat.sendMessage = (function() {
        var message = document.getElementById('chat').value;
        if (message != '') {
            obj = {
                message : message,
                from : userid,
                to : -1
            };
            Chat.socket.send(JSON.stringify(obj));
            var html = $("#msgList").html() + '<div class="msg-item avatar-me"><img class="msg-item-friend-avatar" src="http://img5.imgtn.bdimg.com/it/u=1822899106,40471411&fm=27&gp=0.jpg"><div class="msg-item-right"><div class="msg-item-right-name">lionel</div><div class="msg-item-send-time">'+getNowFormatDate()+'</div><div class="msg-item-right-content">'+message+'</div><div style="clear:both;"></div></div></div>';
            $("#msgList").html(html);
            document.getElementById('chat').value = '';
            //Console.log(message);
        }
    });

    Chat.sendPersonalMessage = (function() {
        var content = $("#console").children("p:first-child").text();
        var to = content.substring(0, content.indexOf(":"));
        var message = document.getElementById('chat').value;
        if (message != '') {
            obj = {
                message : message,
                from : userid,
                to : to
            };
            Chat.socket.send(JSON.stringify(obj));
            document.getElementById('chat').value = '';
            //Console.log(message);
        }
    });

    /* var Console = {};

    Console.log = (function(message) {
        var console = document.getElementById('console');
        var p = document.createElement('p');
        p.style.wordWrap = 'break-word';
        p.innerHTML = message;
        console.appendChild(p);
        while (console.childNodes.length > 25) {
            console.removeChild(console.firstChild);
        }
        console.scrollTop = console.scrollHeight;
    }); */

    Chat.initialize();

    document.getElementById('btnSend').onclick = function(){
        Chat.sendMessage();
    }

    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        var hour = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        if(hour >= 0 && hour <= 9){
                hour = "0" + hour;
        }
        if(minutes >= 0 && minutes <= 9){
                minutes = "0" + minutes;
        }
        if(seconds >= 0 && seconds <= 9){
                seconds = "0" + seconds;
        }

        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                + " " + hour+ seperator2 + minutes
                + seperator2 + seconds;
        return currentdate;
    }

    </script>
</body>
</html>