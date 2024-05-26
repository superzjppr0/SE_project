import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class checkout extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkout frame = new checkout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 private void populateTable(String enteredUsername) {
	        // Fetch payment data from the database based on the entered username
	        
	        // Create a DefaultTableModel to hold the data
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Payment ID");
	        model.addColumn("User Name");
	        model.addColumn("Bill");
	        model.addColumn("Status");
	        
	        // Add rows to the model based on the fetched payment data
	        try {
	            DatabaseConnection dbConnection = new DatabaseConnection();
	            Connection connection = dbConnection.getConnection();

	            String query = "SELECT * FROM payment WHERE userName = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, enteredUsername);

	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                String paymentID = resultSet.getString("paymentID");
	                String userName = resultSet.getString("userName");
	                double bill = resultSet.getDouble("bill");
	                String status = resultSet.getString("status");

	                model.addRow(new Object[] { paymentID, userName, bill, status });
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            // Handle the exception appropriately
	        }
	        
	        // Set the model to the table
	        table.setModel(model);
	    }
	 

	public checkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton checkoutButton = new JButton("Check Out");
		checkoutButton.setBackground(Color.blue);
		checkoutButton.setOpaque(true);
		checkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Perform checkout logic here
			}
		});
		checkoutButton.setFont(new Font("Tahoma", Font.BOLD, 29));
		checkoutButton.setBackground(SystemColor.textHighlight);
		checkoutButton.setForeground(Color.BLACK);
		checkoutButton.setBounds(740, 547, 415, 76);
		contentPane.add(checkoutButton);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 0, 100));
		panel_1.setBounds(708, 117, 474, 393);
		contentPane.add(panel_1);

		JLabel totalLabel = new JLabel("Total");
		totalLabel.setForeground(Color.WHITE);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		totalLabel.setBounds(20, 0, 235, 80);
		panel_1.add(totalLabel);

		JLabel currency = new JLabel("");
		currency.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\currency-exchange-icon-2048x2048-s07u6cmi (1).png"));
		currency.setBounds(367, 0, 107, 115);
		panel_1.add(currency);

		table_1 = new JTable();
		table_1.setBounds(30, 90, 350, 278);
		panel_1.add(table_1);

		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(0, 0, 0, 100));
		panel.setBounds(56, 117, 474, 521);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel checkoutLabel = new JLabel("");
		checkoutLabel.setBounds(358, 10, 106, 86);
		panel.add(checkoutLabel);
		checkoutLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\checkout (1).png"));

		JLabel cartLabel = new JLabel("Cart");
		cartLabel.setForeground(SystemColor.textHighlightText);
		cartLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		cartLabel.setBounds(23, 0, 235, 80);
		panel.add(cartLabel);

		table = new JTable();
		table.setBounds(23, 95, 428, 416);
		panel.add(table);

		JLabel backgroundImg = new JLabel("");
		backgroundImg.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\purple-aesthetic-train-57 (1).jpg"));
		backgroundImg.setBounds(0, 0, 1266, 713);
		contentPane.add(backgroundImg);
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