/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import constants.Operations;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DCX
 */
public class HandleClient extends Thread {

    Socket socket;
    boolean end = false;

    public HandleClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!end) {
            Request request = receiveRequest();
            Response response = new Response();
            switch (request.getOperation()) {
                case Operations.PLACEHOLDER:

                    break;
            }
            sendResponse(response);
        }
    }

    private Request receiveRequest() {
        Request request = new Request();
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            request = (Request) in.readObject();
        } catch (Exception ex) {
            Logger.getLogger(HandleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return request;
    }

    private void sendResponse(Response response) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(response);
        } catch (IOException ex) {
            Logger.getLogger(HandleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
