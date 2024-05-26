

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Mainpage extends JFrame {

    private JPanel contentPane;
    private JTextField from;
    private JTextField to;
    private JTable table;
    private String enteredUsername;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	String enteredUsername = "";
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mainpage frame = new Mainpage(enteredUsername);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
   
    public Mainpage(String enteredUsername) {
    	
    	this.enteredUsername = enteredUsername;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 762);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel logout = new JLabel("");
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
                login.setLocationRelativeTo(null);
            }
        });
        
        JLabel lblNewLabel_1 = new JLabel("Email");
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(892, 256, 107, 25);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblUserid = new JLabel("userID");
        lblUserid.setForeground(Color.WHITE);
        lblUserid.setBackground(Color.WHITE);
        lblUserid.setFont(new Font("Dialog", Font.BOLD, 16));
        lblUserid.setBounds(183, 256, 790, 25);
        contentPane.add(lblUserid);
        
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setForeground(Color.WHITE);
        lblPhone.setBackground(Color.WHITE);
        lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
        lblPhone.setBounds(720, 256, 253, 25);
        contentPane.add(lblPhone);
        
        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setForeground(Color.WHITE);
        lblUserName.setBackground(Color.WHITE);
        lblUserName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblUserName.setBounds(339, 256, 634, 25);
        contentPane.add(lblUserName);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBackground(Color.WHITE);
        lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
        lblPassword.setBounds(520, 256, 453, 25);
        contentPane.add(lblPassword);
        
        JLabel lblUsername1 = new JLabel("Logged in as: " + enteredUsername);
        lblUsername1.setForeground(Color.WHITE);
        lblUsername1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername1.setBounds(20, 20, 200, 20);
        contentPane.add(lblUsername1);
        
        JLabel checkout = new JLabel("");
        checkout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkout out = new checkout();
                out.setVisible(true);
                dispose();
                out.setLocationRelativeTo(null);
            }
        });

        ImageIcon img = new ImageIcon(this.getClass().getResource("/checkout (1).png"));
        checkout.setBounds(1063, 0, 100, 100);
        checkout.setIcon(img);
        contentPane.add(checkout);
        ImageIcon img1 = new ImageIcon(this.getClass().getResource("/out (3).png"));
        logout.setIcon(img1);
        logout.setBounds(1179, 0, 64, 86);
        contentPane.add(logout);

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(1249, 0, 17, 720);
        contentPane.add(scrollBar);

        JLabel lblNewLabel = new JLabel("TicketBox");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 89));
        lblNewLabel.setBounds(361, 27, 526, 95);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setLayout(null);
        table.setBounds(183, 300, 855, 370);
        contentPane.add(table);

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(0, 152, 255, 230));
        panel.setBounds(183, 140, 855, 63);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel From = new JLabel("     From");
        From.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        From.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                From.setForeground(Color.RED); // Change the text color to red
                From.setBackground(new Color(255, 192, 203)); // Change the background color to pink
                From.setOpaque(true); // Set the label as opaque to display the background color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                From.setForeground(Color.BLACK); // Reset the text color to black when the mouse exits
                From.setBackground(null); // Reset the background color to default when the mouse exits
                From.setOpaque(false); // Set the label as non-opaque to remove the background color
            }
        });
        From.setBounds(0, 0, 129, 60);
        panel.add(From);

        JLabel To = new JLabel("        To");
        To.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        To.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                To.setForeground(Color.RED); // Change the text color to red
                To.setBackground(new Color(255, 192, 203)); // Change the background color to pink
                To.setOpaque(true); // Set the label as opaque to display the background color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                To.setForeground(Color.BLACK); // Reset the text color to black when the mouse exits
                To.setBackground(null); // Reset the background color to default when the mouse exits
                To.setOpaque(false); // Set the label as non-opaque to remove the background color
            }
        });
        To.setBounds(341, 0, 129, 60);
        panel.add(To);

        from = new JTextField();
        from.setBounds(139, 0, 188, 60);
        panel.add(from);
        from.setColumns(10);

        to = new JTextField();
        to.setBounds(480, 0, 240, 60);
        panel.add(to);
        to.setColumns(10);

        JButton searchbutton = new JButton("SEARCH");
        searchbutton.setBounds(721, 0, 134, 63);
        panel.add(searchbutton);
        searchbutton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        searchbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String startDestination = from.getText();
                String endDestination = to.getText();

                try {
                    DatabaseConnection dbConnection = new DatabaseConnection();
                    Connection connection = dbConnection.getConnection();

                    String query = "SELECT * FROM train WHERE start_destination = ? AND end_destination = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, startDestination);
                    statement.setString(2, endDestination);

                    ResultSet resultSet = statement.executeQuery();

                    // Create a table model with heading column
                    String[] columnNames = {"Train ID", "Date", "Start Destination", "End Destination", "Price", "Seat"};
                    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                    while (resultSet.next()) {
                        Object[] rowData = new Object[columnNames.length];
                        for (int i = 0; i < columnNames.length; i++) {
                            rowData[i] = resultSet.getObject(i + 1);
                        }
                        tableModel.addRow(rowData);
                    }

                    table.setModel(tableModel);

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle the exception appropriately
                }
            }
        });

        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.setBounds(183, 680, 129, 32);
        contentPane.add(purchaseButton);
        purchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchaseTicket();
            }
        });

        JLabel backgroundIMG = new JLabel("");
        backgroundIMG.setBackground(new Color(240, 240, 240));
        backgroundIMG.setFont(new Font("Tahoma", Font.PLAIN, 10));
        ImageIcon img2 = new ImageIcon(this.getClass().getResource("/z5475047446885_e0a7e8e6f2987d18dc9fd7d5ca05d884.jpg"));
        backgroundIMG.setIcon(img2);

        backgroundIMG.setBounds(0, 0, 1256, 720);
        contentPane.add(backgroundIMG);
    }

    private void purchaseTicket() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
           
            double bill = Double.parseDouble(table.getValueAt(selectedRow, 4).toString());
String status = "Pending";
            
           

                // Perform any additional logic or display a success message here
                JOptionPane.showMessageDialog(null, "Ticket purchased successfully!");
                checkout checkout	= new checkout();
                checkout.setVisible(true);
                dispose();

        } else {
            // No row is selected, handle the error appropriately
            JOptionPane.showMessageDialog(null, "Please select a train before purchasing a ticket.");
        }
    }

    public class DatabaseConnection {
        private final String DB_URL = "jdbc:mysql://localhost:3306/train";
        private final String USERNAME = "root";
        private final String PASSWORD = "1201Tuong@";

        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }
    }
}
