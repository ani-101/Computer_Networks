import java.net.*;
import java.io.*;
public class Client_Man {
    public static void main(String args[])throws Exception{
        Socket s=new Socket("localhost",3333);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Client enter the string");
        String str="",str2="",dec = "";
        while(!str.equals("stop")){
        str2 = br.readLine(); //reads the string written by client itself

	int length = str2.length(), i;
	String enc = "";
	for(i = 0;i< length;i++)
	{
		if((str2.charAt(i)) == '0')
		{
			enc = enc + "01";
		}
		else{
			enc = enc + "10";
		}

	}

dout.writeUTF(enc); // here code of client starts @1

str=din.readUTF(); //here @2 code further execute
System.out.println("Encoded code is" +""+ str);
int len = str.length();
for (i = 0;i< len;i += 2)
{
	String substr = str.substring(i,i+2);
	if(substr.equals("01"))
	{
		dec = dec + "0";
	}
	if(substr.equals("10"))
	{
		dec = dec + "1";
	}
}

System.out.println("Server's code decoded by client - "+""+ dec);

        }

        dout.close();
        s.close();
        }
        }