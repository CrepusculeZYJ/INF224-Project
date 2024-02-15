/**
 * @file Client.java
 * @brief This file contains the Client class, which is used to connect to the server, then send and receive messages from the server.
*/
package swing;
import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 * @class Client
 * @brief This class is used to connect to the server, then send and receive messages from the server.
*/
public class Client {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    /**
     * @brief This method is used to send a message to the server and receive a response from the server.
     * @param message The message to be sent to the server.
     * @return The response from the server.
    */
    public String sendMessage (String message) {
        try {
            message+="\n";
            writer.write(message);
            writer.flush();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error sending message", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        try {
            String response=reader.readLine();
            return response;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error receiving message", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    /**
     * @brief This constructor is used to connect to the server.
     * @param host The host name of the server.
     * @param port The port number of the server.
     * @throws Exception If an error occurs while connecting to the server.
    */
    public Client (String host, int port) throws Exception{
        try {
            socket = new Socket(host, port);
        }
        catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Host not found", "Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to server", "Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating reader", "Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating writer", "Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }
}