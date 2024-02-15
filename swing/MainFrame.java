/**
 * @file MainFrame.java
 * @brief This file contains the MainFrame class, which is used to create the main frame of the graphical user interface.
*/
package swing;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
/**
 * @class MainFrame
 * @brief This class is used to create the main frame of the graphical user interface.
*/
public class MainFrame extends JFrame {
    private ConnectPanel connectPanel;
    private MainPanel mainPanel;
    private ExitPanel exitPanel;
    private SearchPanel searchPanel;
    private PlayPanel playPanel;
    private CreatePanel createPanel;
    private DeletePanel deletePanel;
    private Client client;

    GridBagConstraints gbc = new GridBagConstraints();

    /**
     * @brief This constructor is used to create the main frame of the graphical user interface.
    */
    public MainFrame() {
        super("Multimedia System");

        setLayout(new GridBagLayout());
        
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        connectPanel = new ConnectPanel();
        add(connectPanel, gbc);

        gbc.insets = new Insets(0, 60, 10, 60);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;

        exitPanel = new ExitPanel();
        add(exitPanel, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        mainPanel = new MainPanel();
        mainPanel.setVisible(false);
        add(mainPanel, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        searchPanel = new SearchPanel();
        searchPanel.setVisible(false);
        add(searchPanel, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        playPanel = new PlayPanel();
        playPanel.setVisible(false);
        add(playPanel, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        createPanel = new CreatePanel();
        createPanel.setVisible(false);
        add(createPanel, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        deletePanel = new DeletePanel();
        deletePanel.setVisible(false);
        add(deletePanel, gbc);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        //setSize(800, 600);
        setVisible(true);
    }
    /**
     * @class ConnectPanel
     * @brief This class is used to create the connection panel of the graphical user interface.
    */
    public class ConnectPanel extends JPanel {
        private JLabel connectLabel;
        private JPanel buttonPanel;
        private JButton connectButton;
        /**
         * @brief This constructor is used to create the connection panel of the graphical user interface, which contains a connect button.
        */
        public ConnectPanel() {
            super();
            setLayout(new BorderLayout());
            setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            
            add(connectLabel=new JLabel("Connect to the server"), BorderLayout.NORTH);
            connectLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            connectLabel.setBorder(new EmptyBorder(20, 20, 5, 20));

            add(buttonPanel=new JPanel(), BorderLayout.SOUTH);
            buttonPanel.setBorder(new EmptyBorder(5, 10, 10, 10));
            connectButton=new JButton("Connect");
            buttonPanel.add(connectButton);
            connectButton.addActionListener(new ConnectListener());
        }
        /**
         * @class ConnectListener
         * @brief This class is used to create the connection listener which listens for the connect button to be clicked.
        */
        class ConnectListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                try {
                    client=new Client("localhost", 3331);
                    JOptionPane.showMessageDialog(null, "Successfully connected to server", "Success", JOptionPane.INFORMATION_MESSAGE);
                    connectPanel.setVisible(false);
                    exitPanel.setVisible(false);
                    mainPanel.setVisible(true);
                    setJMenuBar(new MainMenu());
                    pack();
                }
                catch (Exception e) {}
            }
        }
    }
    /**
     * @class ExitPanel
     * @brief This class is used to create the exit panel of the graphical user interface.
    */
    public class ExitPanel extends JPanel {
        private JButton exitButton;
        /**
         * @brief This constructor is used to create the exit panel of the graphical user interface, which contains an exit button.
        */
        public ExitPanel() {
            super();
            setLayout(new BorderLayout());
            add(exitButton=new JButton("Exit"), BorderLayout.SOUTH);
            exitButton.addActionListener(new ExitListener());
        }
        /**
         * @class ExitListener
         * @brief This class is used to create the exit listener which listens for the exit button to be clicked.
        */
        class ExitListener implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        }
    }
    /**
     * @class MainPanel
     * @brief This class is used to create the main panel of the graphical user interface which appears after successful connection.
    */
    public class MainPanel extends JPanel {
        public MainPanel() {
            super();
            setLayout(new BorderLayout());
            setBorder(new LineBorder(Color.LIGHT_GRAY, 2));

            JLabel tipsLabel = new JLabel("Please select a function from the menu");
            tipsLabel.setBorder(new EmptyBorder(50, 10, 50, 10));
            add(tipsLabel);
        }
    }
    /**
     * @class SearchPanel
     * @brief This class is used to create the search panel of the graphical user interface.
    */
    public class SearchPanel extends JPanel {
        /**
         * @brief This constructor is used to create the search panel of the graphical user interface.
        */
        public SearchPanel() {
            super();
            setLayout(new GridBagLayout());
            setBorder(new LineBorder(Color.LIGHT_GRAY, 2));

            JLabel titleLabel = new JLabel("Search");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(titleLabel, gbc);

            FunctionPanel functionPanel = new FunctionPanel();
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(functionPanel, gbc);
        }
        /**
         * @class FunctionPanel
         * @brief This class is used to create the function panel of the search panel, which appears after choosing the search function.
        */
        public class FunctionPanel extends JPanel {
            private JLabel tipsLabel;
            private JPanel inputPanel;
            private JTextField inputField;
            private JButton searchButton;
            /**
             * @brief This constructor is used to create the function panel of the search panel, which appears after choosing the search function.
            */
            public FunctionPanel() {
                super();
                setLayout(new BorderLayout());

                tipsLabel = new JLabel("Please enter the file name");
                add(tipsLabel, BorderLayout.NORTH);

                inputPanel = new JPanel();
                inputPanel.setLayout(new FlowLayout());
                inputField = new JTextField(20);
                inputPanel.add(inputField);

                searchButton = new JButton("Search");
                searchButton.addActionListener(new SearchListener());
                inputPanel.add(searchButton);
                
                add(inputPanel, BorderLayout.CENTER);
            }
            /**
             * @class SearchListener
             * @brief This class is used to create the search listener which listens for the search button to be clicked.
            */
            class SearchListener implements ActionListener {
                public void actionPerformed(ActionEvent evt) {
                    String filmName = inputField.getText();
                    String receivedResponse = client.sendMessage("SEARCH " + filmName);
                    JOptionPane.showMessageDialog(null, receivedResponse, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    /**
     * @class PlayPanel
     * @brief This class is used to create the play panel, which appears after choosing the play function.
    */
    public class PlayPanel extends JPanel {
        /**
         * @brief This constructor is used to create the play panel, which appears after choosing the play function.
        */
        public PlayPanel() {
            super();
            setLayout(new GridBagLayout());
            setBorder(new LineBorder(Color.LIGHT_GRAY, 2));

            JLabel titleLabel = new JLabel("Play");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(titleLabel, gbc);

            FunctionPanel functionPanel = new FunctionPanel();
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(functionPanel, gbc);
        }
        /**
         * @class FunctionPanel
         * @brief This class is used to create the function panel of the play panel, which appears after choosing the play function.
        */
        public class FunctionPanel extends JPanel {
            private JLabel tipsLabel;
            private JPanel inputPanel;
            private JTextField inputField;
            private JButton playButton;
            /**
             * @brief This constructor is used to create the function panel of the play panel, which appears after choosing the play function.
            */
            public FunctionPanel() {
                super();
                setLayout(new BorderLayout());

                tipsLabel = new JLabel("Please enter the file name");
                add(tipsLabel, BorderLayout.NORTH);

                inputPanel = new JPanel();
                inputPanel.setLayout(new FlowLayout());
                inputField = new JTextField(20);
                inputPanel.add(inputField);

                playButton = new JButton("Play");
                playButton.addActionListener(new PlayListener());
                inputPanel.add(playButton);
                
                add(inputPanel, BorderLayout.CENTER);
            }
            /**
             * @class PlayListener
             * @brief This class is used to create the play listener which listens for the play button to be clicked.
            */
            class PlayListener implements ActionListener {
                public void actionPerformed(ActionEvent evt) {
                    String filmName = inputField.getText();
                    String receivedResponse = client.sendMessage("PLAY " + filmName);
                    JOptionPane.showMessageDialog(null, receivedResponse, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    /**
     * @class CreatePanel
     * @brief This class is used to create the create panel, which appears after choosing the create function. When using this function, the user can create a photo or a video.
    */
    public class CreatePanel extends JPanel {
        /**
         * @brief This constructor is used to create the create panel, which appears after choosing the create function.
        */
        public CreatePanel() {
            super();
            setLayout(new GridBagLayout());
            setBorder(new LineBorder(Color.LIGHT_GRAY, 2));

            JLabel titleLabel = new JLabel("Create");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(titleLabel, gbc);

            FunctionPanel functionPanel = new FunctionPanel();
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(functionPanel, gbc);
        }
        /**
         * @class FunctionPanel
         * @brief This class is used to create the function panel of the create panel, which appears after choosing the create function.
        */
        public class FunctionPanel extends JPanel {
            private JLabel tipsLabel;
            private JPanel inputPanel;
            private JPanel choosePanel;
            private ButtonGroup buttonGroup;
            private CreatePhotoPanel createPhotoPanel;
            private CreateVideoPanel createVideoPanel;
            private JTextField nameInputFieldPhoto, pathnameInputFieldPhoto, latitudeInputField, longitudeInputField;
            private JTextField nameInputFieldVideo, pathnameInputFieldVideo, durationInputField;
            private JLabel nameLabel, pathnameLabel, latitudeLabel, longitudeLabel, durationLabel;
            private JButton createPhotoButton, createVideoButton;
            /**
             * @brief This constructor is used to create the function panel of the create panel, which appears after choosing the create function.
            */
            public FunctionPanel() {
                super();
                setLayout(new BorderLayout());

                tipsLabel = new JLabel("Please select the multimedia type you want to create");
                add(tipsLabel, BorderLayout.NORTH);

                inputPanel = new JPanel();
                inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
                choosePanel = new JPanel();
                buttonGroup = new ButtonGroup();

                JRadioButton photoButton = new JRadioButton("Photo");
                JRadioButton videoButton = new JRadioButton("Video");
                photoButton.addActionListener(new CreatePhotoListener());
                videoButton.addActionListener(new CreateVideoListener());
                buttonGroup.add(photoButton);
                buttonGroup.add(videoButton);
                choosePanel.add(photoButton);
                choosePanel.add(videoButton);

                inputPanel.add(choosePanel);

                createPhotoPanel = new CreatePhotoPanel();
                createVideoPanel = new CreateVideoPanel();
                createPhotoPanel.setVisible(false);
                createVideoPanel.setVisible(false);

                inputPanel.add(createPhotoPanel);
                inputPanel.add(createVideoPanel);
                
                add(inputPanel, BorderLayout.CENTER);
            }
            /**
             * @class CreatePhotoPanel
             * @brief This class is used to create the create photo panel, which appears after clicking on photo.
            */
            class CreatePhotoPanel extends JPanel {
                /**
                 * @brief This constructor is used to create the create photo panel, which appears after clicking on photo.
                */
                public CreatePhotoPanel() {
                    super();
                    setLayout(new BorderLayout());

                    JPanel CreatePhotoInfoPanel = new JPanel();
                    CreatePhotoInfoPanel.setLayout(new BoxLayout(CreatePhotoInfoPanel, BoxLayout.Y_AXIS));

                    nameLabel = new JLabel("Name");
                    CreatePhotoInfoPanel.add(nameLabel);
                    nameInputFieldPhoto = new JTextField(20);
                    CreatePhotoInfoPanel.add(nameInputFieldPhoto);
                    pathnameLabel = new JLabel("Pathname");
                    CreatePhotoInfoPanel.add(pathnameLabel);
                    pathnameInputFieldPhoto = new JTextField(20);
                    CreatePhotoInfoPanel.add(pathnameInputFieldPhoto);
                    latitudeLabel = new JLabel("Latitude");
                    CreatePhotoInfoPanel.add(latitudeLabel);
                    latitudeInputField = new JTextField(20);
                    CreatePhotoInfoPanel.add(latitudeInputField);
                    longitudeLabel = new JLabel("Longitude");
                    CreatePhotoInfoPanel.add(longitudeLabel);
                    longitudeInputField = new JTextField(20);
                    CreatePhotoInfoPanel.add(longitudeInputField);
                    add(CreatePhotoInfoPanel, BorderLayout.NORTH);
                    
                    JPanel createButtonPanel = new JPanel();
                    add(createButtonPanel, BorderLayout.SOUTH);
                    createButtonPanel.setBorder(new EmptyBorder(5, 10, 10, 10));

                    createPhotoButton = new JButton("Create");
                    createPhotoButton.addActionListener(new CreatePhotoEventListener());
                    createButtonPanel.add(createPhotoButton);
                }
                /**
                 * @class CreatePhotoEventListener
                 * @brief This class is used to create the create photo listener which listens for the create photo button to be clicked.
                */
                public class CreatePhotoEventListener implements ActionListener {
                    public void actionPerformed(ActionEvent evt) {
                        String name = nameInputFieldPhoto.getText();
                        String pathname = pathnameInputFieldPhoto.getText();
                        String latitude = latitudeInputField.getText();
                        String longitude = longitudeInputField.getText();
                        String receivedResponse = client.sendMessage("CREATE PHOTO " + name + " " + pathname + " " + latitude + " " + longitude);
                        JOptionPane.showMessageDialog(null, receivedResponse, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            /**
             * @class CreateVideoPanel
             * @brief This class is used to create the create video panel, which appears after clicking on video.
            */
            class CreateVideoPanel extends JPanel {
                /**
                 * @brief This constructor is used to create the create video panel, which appears after clicking on video.
                */
                public CreateVideoPanel() {
                    super();
                    setLayout(new BorderLayout());

                    JPanel CreateVideoInfoPanel = new JPanel();
                    CreateVideoInfoPanel.setLayout(new BoxLayout(CreateVideoInfoPanel, BoxLayout.Y_AXIS));

                    nameLabel = new JLabel("Name");
                    CreateVideoInfoPanel.add(nameLabel);
                    nameInputFieldVideo = new JTextField(20);
                    CreateVideoInfoPanel.add(nameInputFieldVideo);
                    pathnameLabel = new JLabel("Pathname");
                    CreateVideoInfoPanel.add(pathnameLabel);
                    pathnameInputFieldVideo = new JTextField(20);
                    CreateVideoInfoPanel.add(pathnameInputFieldVideo);
                    durationLabel = new JLabel("Duration");
                    CreateVideoInfoPanel.add(durationLabel);
                    durationInputField = new JTextField(20);
                    CreateVideoInfoPanel.add(durationInputField);
                    add(CreateVideoInfoPanel, BorderLayout.NORTH);
                    
                    JPanel createButtonPanel = new JPanel();
                    add(createButtonPanel, BorderLayout.SOUTH);
                    createButtonPanel.setBorder(new EmptyBorder(5, 10, 10, 10));

                    createVideoButton = new JButton("Create");
                    createVideoButton.addActionListener(new CreateVideoEventListener());
                    createButtonPanel.add(createVideoButton);
                }
                /**
                 * @class CreateVideoEventListener
                 * @brief This class is used to create the create video listener which listens for the create video button to be clicked.
                */
                public class CreateVideoEventListener implements ActionListener {
                    public void actionPerformed(ActionEvent evt) {
                        String name = nameInputFieldVideo.getText();
                        String pathname = pathnameInputFieldVideo.getText();
                        String duration = durationInputField.getText();
                        String receivedResponse = client.sendMessage("CREATE VIDEO " + name + " " + pathname + " " + duration);
                        JOptionPane.showMessageDialog(null, receivedResponse, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            /**
             * @class CreatePhotoListener
             * @brief This class is used to create the create photo listener which listens for the photo button to be clicked.
            */
            class CreatePhotoListener implements ActionListener {
                public void actionPerformed(ActionEvent evt) {
                    createPhotoPanel.setVisible(true);
                    createVideoPanel.setVisible(false);
                    pack();
                }
            }
            /**
             * @class CreateVideoListener
             * @brief This class is used to create the create video listener which listens for the video button to be clicked.
            */
            class CreateVideoListener implements ActionListener {
                public void actionPerformed(ActionEvent evt) {
                    createPhotoPanel.setVisible(false);
                    createVideoPanel.setVisible(true);
                    pack();
                }
            }
        }
    }
    /**
     * @class DeletePanel
     * @brief This class is used to create the delete panel, which appears after choosing the delete function.
    */
    public class DeletePanel extends JPanel {
        /**
         * @brief This constructor is used to create the delete panel, which appears after choosing the delete function.
        */
        public DeletePanel() {
            super();
            setLayout(new GridBagLayout());
            setBorder(new LineBorder(Color.LIGHT_GRAY, 2));

            JLabel titleLabel = new JLabel("Delete");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(titleLabel, gbc);

            FunctionPanel functionPanel = new FunctionPanel();
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(functionPanel, gbc);
        }
        /**
         * @class FunctionPanel
         * @brief This class is used to create the function panel of the delete panel, which appears after choosing the delete function.
        */
        public class FunctionPanel extends JPanel {
            private JLabel tipsLabel;
            private JPanel inputPanel;
            private JTextField inputField;
            private JButton deleteButton;
            public FunctionPanel() {
                super();
                setLayout(new BorderLayout());

                tipsLabel = new JLabel("Please enter the file name");
                add(tipsLabel, BorderLayout.NORTH);

                inputPanel = new JPanel();
                inputPanel.setLayout(new FlowLayout());
                inputField = new JTextField(20);
                inputPanel.add(inputField);

                deleteButton = new JButton("Delete");
                deleteButton.addActionListener(new DeleteListener());
                inputPanel.add(deleteButton);
                
                add(inputPanel, BorderLayout.CENTER);
            }
            /**
             * @class DeleteListener
             * @brief This class is used to create the delete listener which listens for the delete button to be clicked.
            */
            class DeleteListener implements ActionListener {
                public void actionPerformed(ActionEvent evt) {
                    String filmName = inputField.getText();
                    String receivedResponse = client.sendMessage("DELETE " + filmName);
                    JOptionPane.showMessageDialog(null, receivedResponse, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    /**
     * @class MainMenu
     * @brief This class is used to create the main menu of the graphical user interface.
    */
    public class MainMenu extends JMenuBar implements ActionListener{
        /**
         * @brief This constructor is used to create the main menu of the graphical user interface.
        */
        public MainMenu() {
            JMenu functionMenu = new JMenu("Function");
            JMenuItem searchItem = new JMenuItem("Search");
            JMenuItem playItem = new JMenuItem("Play");
            JMenuItem createItem = new JMenuItem("Create");
            JMenuItem deleteItem = new JMenuItem("Delete");
            JMenuItem exitItem = new JMenuItem("Exit");
            searchItem.addActionListener(this);
            functionMenu.add(searchItem);
            playItem.addActionListener(this);
            functionMenu.add(playItem);
            createItem.addActionListener(this);
            functionMenu.add(createItem);
            deleteItem.addActionListener(this);
            functionMenu.add(deleteItem);
            exitItem.addActionListener(this);
            functionMenu.add(exitItem);
            add(functionMenu);
        }
        /**
         * @brief This method is used to listen for the menu items to be clicked.
        */
        public void actionPerformed(ActionEvent evt) {
            String command = evt.getActionCommand();
            if (command.equals("Search")) {
                mainPanel.setVisible(false);
                playPanel.setVisible(false);
                searchPanel.setVisible(true);
                createPanel.setVisible(false);
                deletePanel.setVisible(false);
                pack();
            }
            else if (command.equals("Play")) {
                mainPanel.setVisible(false);
                searchPanel.setVisible(false);
                playPanel.setVisible(true);
                createPanel.setVisible(false);
                deletePanel.setVisible(false);
                pack();
            }
            else if (command.equals("Create")) {
                mainPanel.setVisible(false);
                searchPanel.setVisible(false);
                playPanel.setVisible(false);
                createPanel.setVisible(true);
                deletePanel.setVisible(false);
                pack();
            }
            else if (command.equals("Delete")) {
                mainPanel.setVisible(false);
                searchPanel.setVisible(false);
                playPanel.setVisible(false);
                createPanel.setVisible(false);
                deletePanel.setVisible(true);
                pack();
            }
            else if (command.equals("Exit")) {
                System.exit(0);
            }
        }
    }
}