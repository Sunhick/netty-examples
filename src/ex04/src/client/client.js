// Javascript websocket client
const ws = new WebSocket("ws:/localhost:9999/ws/ping");

ws.onopen = function (event) {
  ws.send("Here's some text that the server is urgently awaiting!");
};

ws.onmessage = function (event) {
  console.log("RESPONSE -- " + event.data);
}

ws.send("Hello Sunil");
