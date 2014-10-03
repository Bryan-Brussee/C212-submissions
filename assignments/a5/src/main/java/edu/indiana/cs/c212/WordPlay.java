package edu.indiana.cs.c212;

import edu.indiana.cs.c212.Album;
import edu.indiana.cs.c212.Fridge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.StringTokenizer;

@SuppressWarnings("serial")
public class WordPlay extends JFrame {
    public static final Color COLOR = Fridge.COLOR;

    private Fridge fridge;
    private Album  album;

    public WordPlay() {
        JPanel panel = setupScreen();
        fetchWords("This is my horrible string of goodly awesome nessssss");
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }

    public final void paint(Graphics tablet) {
        fridge.repaint();
        album.repaint();
    }

    private JPanel setupScreen() {
        fridge = new Fridge();
        album = new Album(fridge);

        JPanel holderPanel = new JPanel();
        holderPanel.setLayout(new BorderLayout());
        holderPanel.add(fridge, BorderLayout.CENTER);
        holderPanel.add(album, BorderLayout.EAST);
        holderPanel.setBackground(COLOR);

        return holderPanel;
    }

    /**
     * This method gets words from the provided input string.
     * It parses the string through a number of pattern matchers to remove whitespace, punctuation,
     * and digits. Then it removes those characters, and runs the string through a tokenizer to 
     * extract individual words.  Once it has extracted the individual words, it creates new magnets
     * using those words and adds those magnets to the fridge.
     */
    private void fetchWords(String s) {
        String inputString = s;
        if (inputString == null) {
            inputString = "Please give me wordsssss";
        }

        String whitespacePatternMatcher = "\\s";
        String punctuationPatternMatcher = "\\p{Punct}";
        String digitsPatternMatcher = "[0-9]";
        String everythingButLettersPatternMatcher = "("
                + whitespacePatternMatcher + "|" + punctuationPatternMatcher
                + "|" + digitsPatternMatcher + ")";

        inputString = inputString.replaceAll(
                everythingButLettersPatternMatcher, ",");
        
        //FIXME
        //Tokenize the inputString using a StringTokenizer
        //Once the inputString has been tokenized, add every 
        //token to the fridge as a new magnet.
    }

    public static void main(final String[] args) {
        WordPlay words = new WordPlay();
        words.setDefaultCloseOperation(EXIT_ON_CLOSE);
        words.setSize(Fridge.PREFERRED_SIZE);
        words.setVisible(true);
    }
}
