package DemoLoginUpdate;

import java.io.*;
import java.net.Socket;

public class ServerThread extends  Thread{
    Socket s = null;
    InputStream is = null;
    ObjectInputStream ois = null;
    OutputStream os = null;
    DataOutputStream dos = null;
    public ServerThread(Socket s){
        this.s = s;
    }
    @Override
    public void run() {
        //对于服务器端，利用流来接受数据

        try {
            is = s.getInputStream();
            ois = new ObjectInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = null;
        try {
            user = (User) ois.readObject();
            String str  = null;
            if(user.getUsername().equals("lili")&&user.getPassword().equals(
                    "123123")){
                str="Successfully login. Welcome back.";
            }else{
                str="Login failed.";
            }

            //服务器对客户端的响应
            s.shutdownInput();
            os = s.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(dos!= null){
                    dos.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(os!= null){
                    os.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(ois!= null){
                    ois.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!= null){
                    is.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //校验一下

    }
}
