var chatApp = angular.module('chatApp', ['ui']);

chatApp.controller('ChatController', function ChatController($scope, $http) {

    $scope.wsUri = "ws://localhost:8090/chat-listener";
    $scope.websocket = new WebSocket($scope.wsUri);
    $scope.showHead = true;
    $scope.showBody = false;
    $scope.name="";
    $scope.chats=[];

    $scope.login = function(){
        if($scope.name.trim() === ""){
            alert("请输入登录名!");
            return;
        }

        $scope.websocket.send($scope.name);
        $scope.showHead = false;
        $scope.showBody = true;
        $("say").focus();
    }

    $scope.send = function(){
        $scope.websocket.send($scope.say);
        $scope.say = "";
        $("say").focus();

    }

    $scope.websocket.onopen = function (evt) {
    };

    $scope.websocket.onclose = function (evt) {
        $scope.chats.push("主人，连接已断开！");
    };

    $scope.websocket.onmessage = function (evt) {
        $scope.chats.push(evt.data);
        $scope.$apply();
    };

    $scope.websocket.onerror = function (evt) {
        $scope.chats.push("主人，出错了！");
    };


});