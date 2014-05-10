package com.springapp.mvc.ssss;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
*
* @author nb
*/
//@ClientEndpoint
@ServerEndpoint(value = "/messages/serv")
public class MyWhiteboard {

    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    private static List<String> messages = Collections.synchronizedList(new ArrayList<String>());

    @OnOpen
    public void onOpen(Session peer) {
        if(messages.size() > 20 )
            messages.remove(0);
        try {
            peer.getBasicRemote().sendObject(messages);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }

        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer, CloseReason reason) {
        //peers.remove(peer);
        System.out.println(reason.toString());
    }

    @OnMessage
    public void broadcastFigure(String figure, Session session) throws IOException, EncodeException {
        messages.add(figure);
        System.out.println("broadcastFigure: " + figure);
        for (Session peer : peers) {
            if (!peer.equals(session)) {
                peer.getBasicRemote().sendText(figure); //.sendObject(figure);
            }
        }
    }



}
