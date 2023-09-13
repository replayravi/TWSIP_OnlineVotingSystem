import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

class OnlineVotingSystem{
    static HashMap<String, String> map = new HashMap<>();
    static int A = 0;
    static int B = 0;
    static int C = 0;
    static String out;

    public static void main(String[] args) {
        JFrame f = new JFrame("Online Voting System");
        JPanel p = new JPanel();
        JLabel head = new JLabel("ONLINE VOTING SYSTEM");
        JLabel l1 = new JLabel("    ENTER NAME");
        JLabel l2 = new JLabel("    ENTER PHONE");
        JLabel l3 = new JLabel("    CAST YOUR VOTE HERE");
        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        JRadioButton r1 = new JRadioButton("PARTY A");
        JRadioButton r2 = new JRadioButton("PARTY B");
        JRadioButton r3 = new JRadioButton("PARTY C");
        JButton b1 = new JButton("SUBMIT YOUR VOTE");
        JButton b2 = new JButton("CHECK RESULTS");
        ButtonGroup bg = new ButtonGroup();
        Font fs1 = new Font("TIMES NEW ROMAN", Font.BOLD, 30);
        Font fs = new Font("CASTELLAR", Font.PLAIN, 17);
        Font fs2 = new Font("SERIF", Font.PLAIN, 20);
        p.setLayout(null);
        head.setBounds(60, 0, 400, 50);
        l1.setBounds(0, 40, 220, 50);
        l2.setBounds(0, 90, 220, 50);
        l3.setBounds(0, 160, 220, 100);
        tf1.setBounds(210, 50, 300, 30);
        tf2.setBounds(210, 100, 300, 30);
        r1.setBounds(13, 220, 150, 50);
        r2.setBounds(13, 270, 150, 50);
        r3.setBounds(13, 320, 150, 50);
        b1.setBounds(170, 230, 150, 50);
        b2.setBounds(170, 310, 150, 50);
        head.setFont(fs1);
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        p.add(head);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(tf1);
        p.add(tf2);
        p.add(r1);
        p.add(r2);
        p.add(r3);
        p.add(b1);
        p.add(b2);
        b1.addMouseListener(
                new MouseListener() {
                    public void mouseEntered(MouseEvent e) {
                    }

                    public void mouseExited(MouseEvent e) {
                    }

                    public void mousePressed(MouseEvent e) {
                    }

                    public void mouseReleased(MouseEvent e) {
                    }

                    public void mouseClicked(MouseEvent e) {
                        String s1 = tf1.getText();
                        String s2 = tf2.getText();
                        if (s1.isEmpty()) {
                            JOptionPane.showMessageDialog(new JFrame(), "Please Enter name");
                        } else if (s2.isEmpty()) {
                            JOptionPane.showMessageDialog(new JFrame(), "Please Enter phone no");
                        } else if (map.containsKey(s1) || map.containsValue(s2)) {
                            JOptionPane.showMessageDialog(new JFrame(), "You have already voted!!");
                        } else {
                            int i = JOptionPane.showConfirmDialog(new JFrame(), "Do you want to confirm your vote?");
                            if (i == 0) {
                                if (r1.isSelected()) {
                                    A += 1;
                                } else if (r2.isSelected()) {
                                    B += 1;
                                } else if (r3.isSelected()) {
                                    C += 1;
                                }
                                map.put(s1, s2);
                                tf1.setText("");
                                tf2.setText("");
                                bg.clearSelection();
                            }
                        }

                    }
                });
        b2.addMouseListener(
                new MouseListener() {
                    public void mouseEntered(MouseEvent e) {
                    }

                    public void mouseExited(MouseEvent e) {
                    }

                    public void mousePressed(MouseEvent e) {
                    }

                    public void mouseReleased(MouseEvent e) {
                    }

                    public void mouseClicked(MouseEvent e) {
                        if (A > B && A > C) {
                            out = "PARTY A Has a lead";
                        } else if (B > A && B > C) {
                            out = "PARTY B Has a lead";
                        } else if (C > A && C > B) {
                            out = "PARTY C Has a lead";
                        } else {
                            out = "No PARTY Has a lead";
                        }
                        JOptionPane.showMessageDialog(new JFrame(), "PARTY A " + A + " \nPARTY B " + B
                                + " \nPARTY C " + C + "\n\n" + out);
                    }
                });
        f.add(p);
        f.setSize(600, 500);
        f.setLocation(300, 80);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}