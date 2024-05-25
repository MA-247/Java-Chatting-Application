package Whatsapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Client extends JFrame implements ActionListener
{
JPanel p1;
JTextField t1;
JButton b1;
static JTextArea a1;

static Socket s;
static DataInputStream din;
static DataOutputStream dout;


Client()
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


ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("whatsapp/icons/2.png"));
Image i5 = i4.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
ImageIcon i6 =  new ImageIcon(i5);
JLabel l2 = new JLabel (i6);
setLayout(null);
l2.setBounds(40,5,60,60);
p1.add(l2);

String naam1 =  new String();
registration2 r1 = new registration2();
naam1 = r1.getUsername();

JLabel l3  =  new JLabel(naam1);
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
setLocation(900, 50);
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
}catch (Exception e){}
}

public static void main(String[] args)
{
new Client().setVisible(true);

try
{
s = new Socket("127.0.0.1",4200);
din = new DataInputStream(s.getInputStream());
dout = new DataOutputStream(s.getOutputStream());

String messageInput = "";

messageInput = din.readUTF();
a1.setText(a1.getText() + "\n"+messageInput);

}catch (Exception e){}
}
}




Registration (NetBeans design portal was used so, the code is auto generated, only code which was used to give the functionality is given below):

static String userName = new String();
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        
userName = name.getText();
Server chat1 = new Server();
chat1.setVisible(true);

}
public String getUserName()
{
return userName;
}

/**
* @param args the command line arguments
*/
public static void main(String args[]) {
/* Set the Nimbus look and feel */
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
* For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
*/
try {
for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
if ("Nimbus".equals(info.getName())) {
javax.swing.UIManager.setLookAndFeel(info.getClassName());
break;
}
}
} catch (ClassNotFoundException ex) {
java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
//</editor-fold>

/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {

}
});
}
