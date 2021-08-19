package constants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.UIManager;

import data.Evidence;
import data.Ghost;

/**
 * Class containing various constants
 * @author Francis Leroux-Contant
 * @version 2021-08-17
 */
public class Constants {

	/*******************************
	 * EVIDENCE DEFAULT ATTRIBUTES *
	 *******************************/
	public static final int INVALID_EVIDENCE_ID = -1;
	public static final String INVALID_EVIDENCE_TEXT = "";
	
	/****************************
	 * GHOST DEFAULT ATTRIBUTES *
	 ****************************/
	public static final int MAX_AMOUNT_EVIDENCE = 3; 
	public static final int INVALID_GHOST_ID = -1;
	public static final String INVALID_GHOST_NAME = "Unknown";
	
	/***************
	 * GHOST TYPES *
	 ***************/
	public static final String SPIRIT_TEXT = "Spirit";
	public static final String WRAITH_TEXT = "Wraith";
	public static final String PHANTOM_TEXT = "Phantom";
	public static final String POLTERGEIST_TEXT = "Poltergeist";
	public static final String BANSHEE_TEXT = "Banshee";
	public static final String JINN_TEXT = "Jinn";
	public static final String MARE_TEXT = "Mare";
	public static final String REVENANT_TEXT = "Revenant";
	public static final String SHADE_TEXT = "Shade";
	public static final String DEMON_TEXT = "Demon";
	public static final String YUREI_TEXT = "Yurei";
	public static final String ONI_TEXT = "Oni";
	public static final String YOKAI_TEXT = "Yokai";
	public static final String HANTU_TEXT = "Hantu";
	
	/*************
	 * GHOST IDs *
	 *************/
	public static final int SPIRIT_ID = 1;
	public static final int WRAITH_ID = 2;
	public static final int PHANTOM_ID = 3;
	public static final int POLTERGEIST_ID = 4;
	public static final int BANSHEE_ID = 5;
	public static final int JINN_ID = 6;
	public static final int MARE_ID = 7;
	public static final int REVENANT_ID = 8;
	public static final int SHADE_ID = 9;
	public static final int DEMON_ID = 10;
	public static final int YUREI_ID = 11;
	public static final int ONI_ID = 12;
	public static final int YOKAI_ID = 13;
	public static final int HANTU_ID = 14;
	
	/******************
	 * EVIDENCE TYPES *
	 ******************/
	public static final String EMF_TEXT = "EMF Level 5";
	public static final String FINGERPRINTS_TEXT = "Fingerprints";
	public static final String FREEZING_TEXT = "Freezing Temperatures";
	public static final String ORB_TEXT = "Ghost Orb";
	public static final String WRITING_TEXT = "Ghost Writing";
	public static final String BOX_TEXT = "Spirit Box";
	
	/****************
	 * EVIDENCE IDs *
	 ****************/
	public static final int EMF_ID = 1;
	public static final int FINGERPRINTS_ID = 2;
	public static final int FREEZING_ID = 3;
	public static final int ORB_ID = 4;
	public static final int WRITING_ID = 5;
	public static final int BOX_ID = 6;
	
	/*************
	 * EVIDENCES *
	 *************/
	public static final Evidence EMF = new Evidence(EMF_ID, EMF_TEXT);
	public static final Evidence FINGERPRINTS = new Evidence(FINGERPRINTS_ID,
															 FINGERPRINTS_TEXT);
	public static final Evidence FREEZING = new Evidence(FREEZING_ID, 
														 FREEZING_TEXT);
	public static final Evidence ORB = new Evidence(ORB_ID, ORB_TEXT);
	public static final Evidence WRITING = new Evidence(WRITING_ID, 
														WRITING_TEXT);
	public static final Evidence BOX = new Evidence(BOX_ID, BOX_TEXT);
	
	public static final ArrayList<Evidence> ALL_EVIDENCES = new ArrayList<>(
			Arrays.asList(EMF, FINGERPRINTS, FREEZING, ORB, WRITING, BOX));
	
	/**************
	 * GHOST LIST *
	 **************/
	public static final Ghost SPIRIT = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, WRITING, BOX)), 
			SPIRIT_ID, SPIRIT_TEXT);
	public static final Ghost WRAITH = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, FREEZING, BOX)), 
			WRAITH_ID, WRAITH_TEXT);
	public static final Ghost PHANTOM = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FREEZING, ORB)), 
			PHANTOM_ID, PHANTOM_TEXT);
	public static final Ghost POLTERGEIST = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, ORB, BOX)), 
			POLTERGEIST_ID, POLTERGEIST_TEXT);
	public static final Ghost BANSHEE = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FINGERPRINTS, FREEZING)), 
			BANSHEE_ID, BANSHEE_TEXT);
	public static final Ghost JINN = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, ORB, BOX)), 
			JINN_ID, JINN_TEXT);
	public static final Ghost MARE = new Ghost(
			new ArrayList<>(Arrays.asList(FREEZING, ORB, BOX)), 
			MARE_ID, MARE_TEXT);
	public static final Ghost REVENANT = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FINGERPRINTS, WRITING)), 
			REVENANT_ID, REVENANT_TEXT);
	public static final Ghost SHADE = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, ORB, WRITING)), 
			SHADE_ID, SHADE_TEXT);
	public static final Ghost DEMON = new Ghost(
			new ArrayList<>(Arrays.asList(FREEZING, WRITING, BOX)), 
			DEMON_ID, DEMON_TEXT);
	public static final Ghost YUREI = new Ghost(
			new ArrayList<>(Arrays.asList(FREEZING, ORB, WRITING)), 
			YUREI_ID, YUREI_TEXT);
	public static final Ghost ONI = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, WRITING, BOX)), 
			ONI_ID, ONI_TEXT);
	public static final Ghost YOKAI = new Ghost(
			new ArrayList<>(Arrays.asList(ORB, WRITING, BOX)), 
			YOKAI_ID, YOKAI_TEXT);
	public static final Ghost HANTU = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, ORB, WRITING)), 
			HANTU_ID, HANTU_TEXT);
	public static final ArrayList<Ghost> ALL_GHOSTS = new ArrayList<>(
			Arrays.asList(SPIRIT, WRAITH, PHANTOM, POLTERGEIST, 
					      BANSHEE, JINN, MARE, REVENANT, SHADE, 
					      DEMON, YUREI, ONI, YOKAI, HANTU));

	/*************************
	 * LEFT PANEL DIMENSIONS *
	 *************************/
	public static final Dimension BIG_RIGID_AREA_DIM = new Dimension(125, 5);
	public static final Dimension SMALL_RIGID_AREA_DIM = new Dimension(0, 5);
	
	
	/****************
	 * SCREEN SIZES *
	 ****************/
	public static final Dimension ACTUAL_SCREEN_SIZE = 
									Toolkit.getDefaultToolkit().getScreenSize();

	public static final Dimension MAX_SCREEN_SIZE = new Dimension(550, 600);
	public static final Dimension TOP_PANEL_SIZE = new Dimension(MAX_SCREEN_SIZE.width, (int) (MAX_SCREEN_SIZE.height*0.75));
	public static final Dimension BOT_PANEL_SIZE = new Dimension(MAX_SCREEN_SIZE.width, (int) (MAX_SCREEN_SIZE.height*0.25));
	public static final Dimension WRONG_GHOST_FRAME_SIZE = new Dimension(180, 125);
	
	/*****************
	 * BUTTON STATES *
	 *****************/
	public static final int BUTTON_INACTIVE_STATE = 0;
	public static final int BUTTON_ACTIVE_STATE = 1;
	
	
	/*****************
	 * BUTTON COLORS *
	 *****************/
	public static final Color BUTTON_DEFAULT_COLOR = 
										UIManager.getColor("Button.background");
	public static final Color BUTTON_YES_COLOR = Color.GREEN;
	public static final Color BUTTON_NO_COLOR = Color.RED;
	
	/***************
	 * BUTTON SIZE *
	 ***************/
	public static final Dimension BUTTON_SIZE = new Dimension(175, 75);
	
	
}
