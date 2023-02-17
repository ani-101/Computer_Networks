import java.net.*;
import java.io.*;
class Server_Diff{
public static void main(String args[])throws Exception{
ServerSocket ss=new ServerSocket(3333);
Socket s=ss.accept();
DataInputStream din=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

System.out.println("Differential Manchester Encoding");
String str="",str2 ="",dec = "";
int i;
while(!str.equals("stop")){
str=din.readUTF(); // here @1 process starts
System.out.println("Encoded code is"+ str);
int len = str.length(),count=0;
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

System.out.println("Client's code decoded by server by Manchester decoding technique - " +""+ dec);
str2 = br.readLine();
int length = str2.length();
String enc = "";
for(i = 0;i< length;i++)
{
	if(str2.charAt(i) == '0' && i == 0)
	{
		enc = enc + "01";

	}
	else if(str2.charAt(i) == '0' && i != 0)
	{
		enc = enc + enc.charAt(count-2)+enc.charAt(count - 1);

	}
	else if(str2.charAt(i) == '1' && i == 0)
	{
		enc = enc + "10";
	}
	else if(str2.charAt(i) == '1' && i != 0)
	{
			enc = enc + enc.charAt(count-1)+ enc.charAt(count - 2);
	}
	count += 2;


}

dout.writeUTF(enc); // here @2 code goes to client side
}
din.close();
s.close();
ss.close();
}
}