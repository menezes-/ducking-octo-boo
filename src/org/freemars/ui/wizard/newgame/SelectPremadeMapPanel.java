package org.freemars.ui.wizard.newgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import org.freemars.ui.image.FreeMarsImageManager;

public class SelectPremadeMapPanel extends JPanel {

    private JPanel contentPanel;
    private JPanel innerPanel;
    private JLabel iconLabel;
    private ImageIcon icon;
    private JPanel explanationsPanel;
    private JLabel explanationLabel1;
    private JPanel mapsPanel;
    private JPanel preMadeMapsPanel;
    private JPanel preMadeMapButtonsPanel;
    private JPanel openPremadeMapPanel;
    private JLabel openPremadeMapLabel;
    private JButton openPremadeMapButton;
    private JButton marsSmallButton;
    private JButton marsMediumButton;
    private JButton marsLargeButton;
    private JButton marsHugeButton;
    private JPanel mapInformationPanel;
    private JLabel mapNameLabel;
    private JTextField mapNameTextField;
    private JLabel mapDescriptionLabel;
    private JTextField mapDescriptionTextField;
    private JLabel mapFileNameLabel;
    private JTextField mapFileNameTextField;
    private JLabel mapSizeLabel;
    private JTextField mapSizeTextField;
    private JLabel suggestedPlayersLabel;
    private JTextField suggestedPlayersTextField;

    public SelectPremadeMapPanel() {
        iconLabel = new JLabel();
        contentPanel = getContentPanel();
        contentPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        setLayout(new BorderLayout());
        icon = new ImageIcon(FreeMarsImageManager.getInstance().getImage(FreeMarsImageManager.NEW_GAME_WIZARD_4));
        if (icon != null) {
            iconLabel.setIcon(icon);
        }
        iconLabel.setBorder(new EtchedBorder(0));
        add(iconLabel, BorderLayout.LINE_START);
        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.add(getInnerPanel(), BorderLayout.CENTER);
        }
        return contentPanel;
    }

    private JPanel getInnerPanel() {
        if (innerPanel == null) {
            innerPanel = new JPanel(new BorderLayout());
            innerPanel.add(getMapsPanel(), BorderLayout.CENTER);
            innerPanel.add(getMapInformationPanel(), BorderLayout.PAGE_END);
        }
        return innerPanel;
    }

    private JPanel getExplanationsPanel() {
        if (explanationsPanel == null) {
            explanationsPanel = new JPanel(new GridLayout(2, 1));
            explanationsPanel.add(getExplanationLabel1());
            explanationsPanel.add(new JLabel());
        }
        return explanationsPanel;
    }

    private JLabel getExplanationLabel1() {
        if (explanationLabel1 == null) {
            explanationLabel1 = new JLabel("Select a premade map.");
        }
        return explanationLabel1;
    }

    private JButton getMarsSmallButton() {
        if (marsSmallButton == null) {
            marsSmallButton = new JButton("Mars small (40 x 80)");
            marsSmallButton.setActionCommand("MARS_SMALL");
            Image buttonImage = FreeMarsImageManager.getInstance().getImage("MARS_48x48");
            buttonImage = FreeMarsImageManager.createResizedCopy(buttonImage, 24, 24, false, this);
            marsSmallButton.setIcon(new ImageIcon(buttonImage));
        }
        return marsSmallButton;
    }

    private JButton getMarsMediumButton() {
        if (marsMediumButton == null) {
            marsMediumButton = new JButton("Mars medium (45 x 90)");
            marsMediumButton.setActionCommand("MARS_MEDIUM");
            Image buttonImage = FreeMarsImageManager.getInstance().getImage("MARS_48x48");
            buttonImage = FreeMarsImageManager.createResizedCopy(buttonImage, 30, 30, false, this);
            marsMediumButton.setIcon(new ImageIcon(buttonImage));
        }
        return marsMediumButton;
    }

    private JButton getMarsLargeButton() {
        if (marsLargeButton == null) {
            marsLargeButton = new JButton("Mars large (50 x 100)");
            marsLargeButton.setActionCommand("MARS_LARGE");
            Image buttonImage = FreeMarsImageManager.getInstance().getImage("MARS_48x48");
            buttonImage = FreeMarsImageManager.createResizedCopy(buttonImage, 36, 36, false, this);
            marsLargeButton.setIcon(new ImageIcon(buttonImage));
        }
        return marsLargeButton;
    }

    private JButton getMarsHugeButton() {
        if (marsHugeButton == null) {
            marsHugeButton = new JButton("Mars huge (55 x 110)");
            marsHugeButton.setActionCommand("MARS_HUGE");
            Image buttonImage = FreeMarsImageManager.getInstance().getImage("MARS_48x48");
            marsHugeButton.setIcon(new ImageIcon(buttonImage));
        }
        return marsHugeButton;
    }

    private JPanel getMapsPanel() {
        if (mapsPanel == null) {
            mapsPanel = new JPanel(new GridLayout(2, 1, 20, 20));
            mapsPanel.add(getPreMadeMapsPanel());
            mapsPanel.add(getOpenPremadeMapPanel());
        }
        return mapsPanel;
    }

    private JPanel getOpenPremadeMapPanel() {
        if (openPremadeMapPanel == null) {
            openPremadeMapPanel = new JPanel();
            openPremadeMapPanel.add(getOpenPremadeMapLabel());
            openPremadeMapPanel.add(getOpenPremadeMapButton());
        }
        return openPremadeMapPanel;
    }

    private JLabel getOpenPremadeMapLabel() {
        if (openPremadeMapLabel == null) {
            openPremadeMapLabel = new JLabel("Open a premade map :");
        }
        return openPremadeMapLabel;
    }

    private JButton getOpenPremadeMapButton() {
        if (openPremadeMapButton == null) {
            openPremadeMapButton = new JButton("Browse...");
            openPremadeMapButton.setActionCommand("BROWSE");
        }
        return openPremadeMapButton;
    }

    private JPanel getPreMadeMapsPanel() {
        if (preMadeMapsPanel == null) {
            preMadeMapsPanel = new JPanel(new BorderLayout());
            preMadeMapsPanel.add(getExplanationsPanel(), BorderLayout.PAGE_START);
            preMadeMapsPanel.add(getPreMadeMapButtonsPanel(), BorderLayout.CENTER);
        }
        return preMadeMapsPanel;
    }

    private JPanel getPreMadeMapButtonsPanel() {
        if (preMadeMapButtonsPanel == null) {
            preMadeMapButtonsPanel = new JPanel(new GridLayout(0, 2, 5, 5));
            preMadeMapButtonsPanel.add(getMarsSmallButton());
            preMadeMapButtonsPanel.add(getMarsMediumButton());
            preMadeMapButtonsPanel.add(getMarsLargeButton());
            preMadeMapButtonsPanel.add(getMarsHugeButton());
        }
        return preMadeMapButtonsPanel;
    }

    private JPanel getMapInformationPanel() {
        if (mapInformationPanel == null) {
            mapInformationPanel = new JPanel(new GridLayout(0, 2));
            mapInformationPanel.add(getMapNameLabel());
            mapInformationPanel.add(getMapNameTextField());
            mapInformationPanel.add(getMapDescriptionLabel());
            mapInformationPanel.add(getMapDescriptionTextField());
            mapInformationPanel.add(getMapFileNameLabel());
            mapInformationPanel.add(getMapFileNameTextField());
            mapInformationPanel.add(getMapSizeLabel());
            mapInformationPanel.add(getMapSizeTextField());
            mapInformationPanel.add(getSuggestedPlayersLabel());
            mapInformationPanel.add(getSuggestedPlayersTextField());
            mapInformationPanel.add(new JLabel());
            mapInformationPanel.add(new JLabel());
        }
        return mapInformationPanel;
    }

    private JLabel getMapNameLabel() {
        if (mapNameLabel == null) {
            mapNameLabel = new JLabel("Name");
        }
        return mapNameLabel;
    }

    private JTextField getMapNameTextField() {
        if (mapNameTextField == null) {
            mapNameTextField = new JTextField();
            mapNameTextField.setEditable(false);
            mapNameTextField.setPreferredSize(new Dimension(380, 20));
        }
        return mapNameTextField;
    }

    private JLabel getMapDescriptionLabel() {
        if (mapDescriptionLabel == null) {
            mapDescriptionLabel = new JLabel("Description");
        }
        return mapDescriptionLabel;
    }

    private JTextField getMapDescriptionTextField() {
        if (mapDescriptionTextField == null) {
            mapDescriptionTextField = new JTextField();
            mapDescriptionTextField.setEditable(false);
            mapDescriptionTextField.setPreferredSize(new Dimension(380, 20));
        }
        return mapDescriptionTextField;
    }

    private JLabel getMapFileNameLabel() {
        if (mapFileNameLabel == null) {
            mapFileNameLabel = new JLabel("File");
        }
        return mapFileNameLabel;
    }

    private JTextField getMapFileNameTextField() {
        if (mapFileNameTextField == null) {
            mapFileNameTextField = new JTextField();
            mapFileNameTextField.setEditable(false);
            mapFileNameTextField.setPreferredSize(new Dimension(380, 20));
        }
        return mapFileNameTextField;
    }

    private JLabel getMapSizeLabel() {
        if (mapSizeLabel == null) {
            mapSizeLabel = new JLabel("Size");
        }
        return mapSizeLabel;
    }

    private JTextField getMapSizeTextField() {
        if (mapSizeTextField == null) {
            mapSizeTextField = new JTextField();
            mapSizeTextField.setEditable(false);
            mapSizeTextField.setPreferredSize(new Dimension(380, 20));
        }
        return mapSizeTextField;
    }

    private JLabel getSuggestedPlayersLabel() {
        if (suggestedPlayersLabel == null) {
            suggestedPlayersLabel = new JLabel("Suggested players");
        }
        return suggestedPlayersLabel;
    }

    private JTextField getSuggestedPlayersTextField() {
        if (suggestedPlayersTextField == null) {
            suggestedPlayersTextField = new JTextField();
            suggestedPlayersTextField.setEditable(false);
            suggestedPlayersTextField.setPreferredSize(new Dimension(380, 20));
        }
        return suggestedPlayersTextField;
    }

    public void setMapName(String mapName) {
        getMapNameTextField().setText(mapName);
    }

    public void setMapDescription(String mapDescription) {
        getMapDescriptionTextField().setText(mapDescription);
    }

    public void setMapFileName(String mapFileName) {
        getMapFileNameTextField().setText(mapFileName);
    }

    public void setMapSize(String mapSize) {
        getMapSizeTextField().setText(mapSize);
    }

    public void setSuggestedPlayers(String mapSize) {
        getSuggestedPlayersTextField().setText(mapSize);
    }

    public void setActionListener(ActionListener actionListener) {
        getMarsSmallButton().addActionListener(actionListener);
        getMarsMediumButton().addActionListener(actionListener);
        getMarsLargeButton().addActionListener(actionListener);
        getMarsHugeButton().addActionListener(actionListener);
        getOpenPremadeMapButton().addActionListener(actionListener);
    }
}
