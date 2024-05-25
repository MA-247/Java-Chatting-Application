package Whatsapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Server extends JFrame  implements ActionListener
{
JPanel p1;
JTextField t1;
JButton b1;
static JTextArea a1;

static ServerSocket skt;
static Socket s;
static DataInputStream din;
static DataOutputStream dout;

Server()
{
p1 = new JPanel();
p1.setLayout(null);
p1.setBackground(new Color (7, 94, 84));
p1.setBounds(0,0,450,70);
add(p1);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("whatsapp/icons/3.png"));
Image i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
ImageIcon i3 =  new ImageIcon(i2);
JLabel l1 = new JLabel (i3);
setLayout(null);
l1.setBounds(5,17,30,30);
p1.add(l1);

l1.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent ae)
{
System.exit(0);
}
});


ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("whatsapp/icons/1.png"));
Image i5 = i4.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
ImageIcon i6 =  new ImageIcon(i5);
JLabel l2 = new JLabel (i6);
setLayout(null);
l2.setBounds(40,5,60,60);
p1.add(l2);

String naam = new String();
registration r = new registration();
naam = r.getUserName();

JLabel l3  =  new JLabel(naam);
l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
l3.setForeground(Color.white);
l3.setBounds(110,15,100,18);
p1.add(l3);

JLabel l4  =  new JLabel("Online");
l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
l4.setForeground(Color.white);
l4.setBounds(110,35,100,20);
p1.add(l4);

a1 = new JTextArea();
a1.setBounds(5,75, 440, 365);
a1.setFont(new Font("SAN_SERIFF", Font.PLAIN, 16));
a1.setEditable(false);
a1.setLineWrap(true);
a1.setWrapStyleWord(true);
add(a1);

t1 = new JTextField();
t1.setBounds(5, 450, 330, 40);
t1.setFont(new Font("SAN_SERIFF", Font.PLAIN, 16));
add(t1);
setSize(450,500);
setLocation(200, 50);
setUndecorated(true);
setVisible(true);

b1 = new JButton("Send");
b1.setBounds(320, 450, 123, 40);
b1.setBackground(new Color(7, 94, 84));
b1.setForeground(Color.white);
b1.addActionListener(this);
add(b1);
}

public void actionPerformed(ActionEvent ae)
{
try
{
String out = t1.getText();
a1.setText(a1.getText() + "\n\t\t\t"+out);
dout.writeUTF(out);
t1.setText("");
}catch(Exception e){}
}


public static void main(String[] args)
{
new Server().setVisible(true);

String messageInput = "";

try
{
skt = new ServerSocket(4200);
s = skt.accept();
din = new DataInputStream(s.getInputStream());
dout = new DataOutputStream(s.getOutputStream());

messageInput = din.readUTF();
a1.setText(a1.getText() + "\n"+messageInput);

skt.close();
s.close();
}catch(Exception e){}
}
}
