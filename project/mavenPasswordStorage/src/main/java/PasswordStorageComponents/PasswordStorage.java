package PasswordStorageComponents;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordStorage extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel LoginPanel;
	private JPanel searchPanel;
	private JPanel mainSearchPanel;
	private JPanel searchBarPanel;
	private JPanel cardPanel;
	private JPanel usernamePanel;
	private JPanel passwordPanel;
	private JPanel optionPanel;
	private JPanel addPanel;
	private JPanel removePanel;
	private JPanel addBarPanel;
	private JPanel removeBarPanel;
	private JPanel removeMainPanel;
	private JPanel addMainPanel;
	private JPanel addResultsPanel;
	private JPanel removeResultsPanel;
	private JPanel searchResultsPanel;
	private JButton startButton;
	private JButton searchButton;
	private JButton removeOptionButton;
	private JButton addOptionButton;
	private JButton	searchOptionButton;
	private JButton removeBackButton;
	private JButton addBackButton;
	private JButton searchBackButton;
	private JButton addSearchButton;
	private JButton removeSearchButton;
	private CardLayout cardLayout;
	private JTextField searchBar;
	private JTextField password;
	private JTextField username;
	private JTextField addBar;
	private JTextField removeBar;

	public PasswordStorage() {
		
		setTitle("PasswordStorage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setPreferredSize(new Dimension(400,200));
		
	    optionPanel = new JPanel();
	    optionPanel.setLayout(new FlowLayout());
	    
		searchPanel = new JPanel();
		mainSearchPanel = new JPanel();
		mainSearchPanel.setPreferredSize(new Dimension(400,100));
		mainSearchPanel.setLayout(new FlowLayout());
		searchBarPanel = new JPanel();
		searchBarPanel.setPreferredSize(new Dimension(230,100));
		searchBarPanel.add(new JLabel("Search Here:"));
		searchResultsPanel = new JPanel();
		searchResultsPanel.setPreferredSize(new Dimension(400,100));
		searchResultsPanel.add(new JLabel("Results:")); 
	    searchPanel.add(searchBarPanel, BorderLayout.NORTH);
        searchPanel.add(mainSearchPanel, BorderLayout.CENTER); 
        searchPanel.add(searchResultsPanel, BorderLayout.SOUTH);
               
        addPanel = new JPanel();        
        addMainPanel = new JPanel();
        addMainPanel.setPreferredSize(new Dimension(400,100));
        addMainPanel.setLayout(new FlowLayout()); 
        addBarPanel = new JPanel();
        addBarPanel.setPreferredSize(new Dimension(230,100));    
        addBarPanel.add(new JLabel("Search to add:"));
        addResultsPanel = new JPanel();
		addResultsPanel.setPreferredSize(new Dimension(400,100));
		addResultsPanel.add(new JLabel("Results:"));
        addPanel.add(addBarPanel, BorderLayout.NORTH);
        addPanel.add(addMainPanel, BorderLayout.CENTER);
        addPanel.add(addResultsPanel, BorderLayout.SOUTH);        
        
        
        removePanel = new JPanel();
        removeMainPanel = new JPanel();
        removeMainPanel.setPreferredSize(new Dimension(400,100));
        removeMainPanel.setLayout(new FlowLayout());
        removeBarPanel = new JPanel();
        removeBarPanel.setPreferredSize(new Dimension(230,100));
        removeBarPanel.add(new JLabel ("Search to remove:"));
        removeResultsPanel = new JPanel();
		removeResultsPanel.setPreferredSize(new Dimension(400,100));
		removeResultsPanel.add(new JLabel("Results:"));
        removePanel.add(removeBarPanel, BorderLayout.NORTH);
        removePanel.add(removeMainPanel, BorderLayout.CENTER);
        removePanel.add(removeResultsPanel, BorderLayout.SOUTH);
        
        LoginPanel = new JPanel(); 
	    usernamePanel = new JPanel();
	    usernamePanel.add(new JLabel("Enter username:"));
		passwordPanel = new JPanel();
		passwordPanel.add(new JLabel("Enter password:"));
		LoginPanel.add(usernamePanel, BorderLayout.NORTH);
		LoginPanel.add(passwordPanel, BorderLayout.CENTER);
         
	    cardPanel.add(LoginPanel, "LoginPanel");
		cardPanel.add(searchPanel, "searchPanel");
		cardPanel.add(optionPanel, "optionPanel");
		cardPanel.add(addPanel, "addPanel");
		cardPanel.add(removePanel, "removePanel");
		
		searchBar = new JTextField(20);
		searchBarPanel.add(searchBar);
		username = new JTextField(20);
        usernamePanel.add(username);
    	password = new JTextField(20);
        passwordPanel.add(password);
        addBar = new JTextField(20);
        addBarPanel.add(addBar);
        removeBar = new JTextField(20);
        removeBarPanel.add(removeBar);
	
	    startButton = new JButton("Start");
	    LoginPanel.add(startButton);
	    startButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   String usernames = username.getText();
        	   String passwords = password.getText();
               if(usernames.compareTo("username") == 0 && passwords.compareTo("password") == 0)
        	   cardLayout.show(cardPanel, "optionPanel");
               else {
            	   JOptionPane.showMessageDialog(PasswordStorage.this, "Incorrect password or username.");
               }
           }
	    });
	         
    	searchButton = new JButton("Search");
		searchButton.setAlignmentX(CENTER_ALIGNMENT);
		mainSearchPanel.add(searchButton);
		searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchBar.getText();
                // Perform search using the searchTerm
                if(searchTerm.compareTo("") == 0)
                	JOptionPane.showMessageDialog(PasswordStorage.this, "Please try searching again");    
                else {	
                JOptionPane.showMessageDialog(PasswordStorage.this, "Searching for: " + searchTerm);
                }
            }
        });
		
		addSearchButton = new JButton("Search");
		addSearchButton.setAlignmentX(CENTER_ALIGNMENT);
		addMainPanel.add(addSearchButton);
		addSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = addBar.getText();
                // Perform search using the searchTerm
                if(searchTerm.compareTo("") == 0)
                	JOptionPane.showMessageDialog(PasswordStorage.this, "Please try searching again");    
                else {	
                JOptionPane.showMessageDialog(PasswordStorage.this, "Searching for: " + searchTerm);
                }
            }
        });
		
		removeSearchButton = new JButton("Search");
		removeSearchButton.setAlignmentX(CENTER_ALIGNMENT);
		removeMainPanel.add(removeSearchButton);
		removeSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = removeBar.getText();
                // Perform search using the searchTerm
                if(searchTerm.compareTo("") == 0)
                	JOptionPane.showMessageDialog(PasswordStorage.this, "Please try searching again");    
                else {	
                JOptionPane.showMessageDialog(PasswordStorage.this, "Searching for: " + searchTerm);
                }
            }
        });
		
		addOptionButton = new JButton("Add");
		optionPanel.add(addOptionButton);
		addOptionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "addPanel");
			}
		});
		
		searchOptionButton = new JButton("Search");
		optionPanel.add(searchOptionButton);
		searchOptionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "searchPanel");
			}
		});
		
		removeOptionButton = new JButton("Remove");
		optionPanel.add(removeOptionButton);
		removeOptionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "removePanel");
			}
		});
		
		searchBackButton = new JButton("Main Menu");
		mainSearchPanel.add(searchBackButton);
		searchBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				cardLayout.show(cardPanel, "optionPanel");
			}
		});
		
		addBackButton = new JButton("Main Menu");
		addMainPanel.add(addBackButton);
		addBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				cardLayout.show(cardPanel, "optionPanel");
			}
		});
		
		removeBackButton = new JButton("Main Menu");
	    removeMainPanel.add(removeBackButton);
	    removeBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  
				cardLayout.show(cardPanel, "optionPanel");
			}
	    });
		  
        add(cardPanel, BorderLayout.CENTER);
        setVisible(true);
        
        
        
        
    }
	
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new PasswordStorage();
	            }
	        });
	    }
}


