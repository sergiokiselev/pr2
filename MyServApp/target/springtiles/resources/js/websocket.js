/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

var wsUri = "ws://" + document.location.host + document.location.pathname + "serv";
var websocket = new WebSocket(wsUri);
websocket.binaryType = "arraybuffer";


websocket.onmessage = function(evt) { onMessage(evt) };
websocket.onerror = function(evt) { onError(evt) };
websocket.onclose = function(evt) { onClose(evt) };

function sendText(json) {
    console.log("sending text: " + json);
    websocket.send(json);
}

function onMessage(evt) {
    console.log("received: " + evt.data);
    if (typeof evt.data == "string") {
        //alert(evt.data);
        appendMessage(evt.data);
    }
}

function onError(evt) {
    //alert('error');
    //writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function onClose(evt) {
    //alert('close');
}
