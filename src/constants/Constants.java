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
 * @version 2022-06-17
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
	public static final String GORYO_TEXT = "Goryo";
	public static final String MYLING_TEXT = "Myling";
	public static final String TWINS_TEXT = "The Twins";
	public static final String ONRYO_TEXT = "Onryo";
	public static final String RAIJU_TEXT = "Raiju";
	public static final String OBAKE_TEXT = "Obake";
	public static final String MIMIC_TEXT = "The Mimic";
	public static final String DEOGEN_TEXT = "Deogen";
	public static final String MOROI_TEXT = "Moroi";
	public static final String THAYE_TEXT = "Thaye";
	
	
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
	public static final int GORYO_ID = 15;
	public static final int MYLING_ID = 16;
	public static final int TWINS_ID = 17;
	public static final int ONRYO_ID = 18;
	public static final int RAIJU_ID = 19;
	public static final int OBAKE_ID = 20;
	public static final int MIMIC_ID = 21;
	public static final int DEOGEN_ID = 22;
	public static final int MOROI_ID = 23;
	public static final int THAYE_ID = 24;
	
	/******************
	 * EVIDENCE TYPES *
	 ******************/
	public static final String EMF_TEXT = "EMF Level 5";
	public static final String FINGERPRINTS_TEXT = "Fingerprints";
	public static final String FREEZING_TEXT = "Freezing Temperatures";
	public static final String ORB_TEXT = "Ghost Orb";
	public static final String WRITING_TEXT = "Ghost Writing";
	public static final String BOX_TEXT = "Spirit Box";
	public static final String DOTS_TEXT = "D.O.T.S Projector";
	
	/****************
	 * EVIDENCE IDs *
	 ****************/
	public static final int EMF_ID = 1;
	public static final int FINGERPRINTS_ID = 2;
	public static final int FREEZING_ID = 3;
	public static final int ORB_ID = 4;
	public static final int WRITING_ID = 5;
	public static final int BOX_ID = 6;
	public static final int DOTS_ID = 7;
	
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
	public static final Evidence DOTS = new Evidence(DOTS_ID, DOTS_TEXT);
	
	public static final ArrayList<Evidence> ALL_EVIDENCES = new ArrayList<>(
			Arrays.asList(EMF, FINGERPRINTS, FREEZING, ORB, WRITING, BOX, DOTS));
	
	/**************
	 * GHOST LIST *
	 **************/
	public static final Ghost SPIRIT = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, WRITING, BOX)), 
			SPIRIT_ID, SPIRIT_TEXT);
	public static final Ghost WRAITH = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, BOX, DOTS)), 
			WRAITH_ID, WRAITH_TEXT);
	public static final Ghost PHANTOM = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, BOX, DOTS)), 
			PHANTOM_ID, PHANTOM_TEXT);
	public static final Ghost POLTERGEIST = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, WRITING, BOX)), 
			POLTERGEIST_ID, POLTERGEIST_TEXT);
	public static final Ghost BANSHEE = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, ORB, DOTS)), 
			BANSHEE_ID, BANSHEE_TEXT);
	public static final Ghost JINN = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FINGERPRINTS, FREEZING)), 
			JINN_ID, JINN_TEXT);
	public static final Ghost MARE = new Ghost(
			new ArrayList<>(Arrays.asList(ORB, WRITING, BOX)), 
			MARE_ID, MARE_TEXT);
	public static final Ghost REVENANT = new Ghost(
			new ArrayList<>(Arrays.asList(FREEZING, ORB, WRITING)), 
			REVENANT_ID, REVENANT_TEXT);
	public static final Ghost SHADE = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FREEZING, WRITING)), 
			SHADE_ID, SHADE_TEXT);
	public static final Ghost DEMON = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, FREEZING, WRITING)), 
			DEMON_ID, DEMON_TEXT);
	public static final Ghost YUREI = new Ghost(
			new ArrayList<>(Arrays.asList(FREEZING, ORB, DOTS)), 
			YUREI_ID, YUREI_TEXT);
	public static final Ghost ONI = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FREEZING, DOTS)), 
			ONI_ID, ONI_TEXT);
	public static final Ghost YOKAI = new Ghost(
			new ArrayList<>(Arrays.asList(ORB, BOX, DOTS)), 
			YOKAI_ID, YOKAI_TEXT);
	public static final Ghost HANTU = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, FREEZING, ORB)), 
			HANTU_ID, HANTU_TEXT);
	public static final Ghost GORYO = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FINGERPRINTS, DOTS)),
			GORYO_ID, GORYO_TEXT);
	public static final Ghost MYLING = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FINGERPRINTS, WRITING)),
			MYLING_ID, MYLING_TEXT);
	public static final Ghost TWINS = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FREEZING, BOX)),
			TWINS_ID, TWINS_TEXT);
	public static final Ghost ONRYO = new Ghost(
			new ArrayList<>(Arrays.asList(FREEZING, ORB, BOX)),
			ONRYO_ID, ONRYO_TEXT);
	public static final Ghost RAIJU = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, ORB, DOTS)),
			RAIJU_ID, RAIJU_TEXT);
	public static final Ghost OBAKE = new Ghost(
			new ArrayList<>(Arrays.asList(EMF, FINGERPRINTS, ORB)),
			OBAKE_ID, OBAKE_TEXT);
	public static final Ghost MIMIC = new Ghost(
			new ArrayList<>(Arrays.asList(FINGERPRINTS, FREEZING, BOX)),
			MIMIC_ID, MIMIC_TEXT);
	public static final Ghost DEOGEN = new Ghost(
			new ArrayList<>(Arrays.asList(WRITING, BOX, DOTS)),
			DEOGEN_ID, DEOGEN_TEXT);
	public static final Ghost MOROI = new Ghost(
			new ArrayList<>(Arrays.asList(FREEZING, WRITING, BOX)),
			MOROI_ID, MOROI_TEXT);
	public static final Ghost THAYE = new Ghost(
			new ArrayList<>(Arrays.asList(ORB, WRITING, DOTS)),
			THAYE_ID, THAYE_TEXT);
	
	
	public static final ArrayList<Ghost> ALL_GHOSTS = new ArrayList<>(
			Arrays.asList(SPIRIT, WRAITH, PHANTOM, POLTERGEIST, 
					      BANSHEE, JINN, MARE, REVENANT, SHADE, 
					      DEMON, YUREI, ONI, YOKAI, HANTU, GORYO, 
					      MYLING, TWINS, ONRYO, RAIJU, OBAKE, MIMIC, DEOGEN, MOROI, THAYE));

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

	public static final Dimension MAX_SCREEN_SIZE = new Dimension(550, 850);
	public static final Dimension TOP_PANEL_SIZE = new Dimension(MAX_SCREEN_SIZE.width, (int) (MAX_SCREEN_SIZE.height*0.75));
	public static final Dimension BOT_PANEL_SIZE = new Dimension(MAX_SCREEN_SIZE.width, (int) (MAX_SCREEN_SIZE.height*0.25));
	public static final Dimension SMALL_SECONDARY_FRAME_SIZE = new Dimension(180, 125);
	public static final Dimension BIG_SECONDARY_FRAME_SIZE = new Dimension(300, 600);
	
	/*****************
	 * BUTTON STATES *
	 *****************/
	public static final int BUTTON_INACTIVE_STATE = 0;
	public static final int BUTTON_ACTIVE_STATE = 1;
	
	/***************
	 * BUTTON TEXT *
	 ***************/
	public static final String BUTTON_GUESS = "Guess";
	public static final String BUTTON_CLEAR = "CLEAR";
	public static final String BUTTON_SUBMIT = "Submit";
	
	
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
	
	/*********
	 * MENUS *
	 *********/

	public static final String TAB_MENU_STATS = "Statistics";
	public static final String MENU_GENERAL = "General Stats";
	public static final String MENU_HISTORY = "History";
	public static final int MENU_PANEL_BORDER_SIZE_HOR = 55;
	public static final int MENU_PANEL_BORDER_SIZE_VERT = 10;
	public static final int N_COLUMNS = 3;
	public static final String[] MENU_COLUMN_NAMES = {"Guessed", "Ghost", "Date"};
	
	/************
	 * MESSAGES *
	 ************/
	
	public static final String TOO_MANY_GHOSTS_MSG = "You need exactly ONE possible ghosts!";
	public static final String ERROR_MSG = "Error";
	public static final String TAKE_A_GUESS = "Take a guess!";
	public static final String IS_YOUR_GHOST_A_MSG = "Is your ghost a ";
	public static final String QUESTION_MARK = "?";
	public static final String TOO_MANY_EVIDENCES_MSG = "Too many evidences! Choose maximum 3";
	public static final String WHAT_IS_GHOST = "What is the right ghost?";
	public static final String DATABASE_EMPTY_MSG = "Database is empty, play at least one game.";
	
	/******************
	 * DATABASE / SQL *
	 ******************/
	
	public static final String DATABASE_NAME = "PhasmophobiaJournal.db";
	public static final String TABLE_NAME= "games";
	
	public static final String COLUMN_CORRECT_GHOST = "correct_ghost";
	public static final String COLUMN_GHOST_TYPE = "ghost_type";
	public static final String COLUMN_DATE = "date";
	
}
