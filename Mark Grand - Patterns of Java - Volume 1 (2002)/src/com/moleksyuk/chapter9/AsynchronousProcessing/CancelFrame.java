/**
 * 
 */
package com.moleksyuk.chapter9.AsynchronousProcessing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * 
 * Date: Aug 23, 2011
 * 
 * @author moleksyuk
 */
public class CancelFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	JMenu menuFile = new JMenu();
	JMenuItem menuFileDoIt = new JMenuItem();
	JMenuItem menuFileStopDoingIt = new JMenuItem();
	JMenuItem menuFileExit = new JMenuItem();

	JMenu menuHelp = new JMenu();
	JMenuItem menuHelpAbout = new JMenuItem();

	JMenuBar menuBar1 = new JMenuBar();
	BorderLayout borderLaytout1 = new BorderLayout();
	JProgressBar myProgress = new JProgressBar();
	Thread doItThread;

	public CancelFrame() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setJMenuBar(menuBar1);
		this.getContentPane().setLayout(borderLaytout1);
		this.setSize(new Dimension(400, 300));
		this.setTitle("Cancel Example Application");
		menuFile.setText("File");
		menuFileDoIt.setText("Do It");
		menuFileDoIt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fileDoIt_ActionPerformed(e);
			}
		});

		menuFileStopDoingIt.setText("Stop Doing It");
		menuFileStopDoingIt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fileStopDoingIt_ActionPerformed(e);
			}
		});

		menuFileExit.setText("Exit");
		menuFileExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fileExit_ActionPerformed(e);
			}
		});

		menuHelp.setText("Help");
		menuHelpAbout.setText("About");
		menuHelpAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpAbout_ActionPerformed(e);
			}
		});
		menuFile.add(menuFileDoIt);
		menuFile.add(menuFileStopDoingIt);
		menuFile.add(menuFileExit);
		menuHelp.add(menuHelpAbout);
		menuBar1.add(menuFile);
		menuBar1.add(menuHelp);
		this.getContentPane().add(myProgress, BorderLayout.SOUTH);
	}

	void fileDoIt_ActionPerformed(ActionEvent e) {
		doItThread = new Thread() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				try {
					installStopItMenuItem();
					myProgress.setMinimum(0);
					myProgress.setMaximum(19);
					myProgress.setValue(0);
					myProgress.repaint();
					for (int i = 0; i < 20; i++) {
						Thread.currentThread().sleep(300);
						myProgress.setValue(i);
						myProgress.repaint();
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					installDoItMenuItem();
					doItThread = null;
				}
			}
		};
		doItThread.start();
	}

	private void fileStopDoingIt_ActionPerformed(ActionEvent e) {
		if (doItThread != null) {
			doItThread.interrupt();
		}
	}

	private void installStopItMenuItem() {
		menuFile.remove(menuFileDoIt);
		menuFile.insert(menuFileStopDoingIt, 0);
		menuFile.repaint();
	}

	private void installDoItMenuItem() {
		menuFile.remove(menuFileStopDoingIt);
		menuFile.insert(menuFileDoIt, 0);
		menuFile.repaint();
	}

	private void fileExit_ActionPerformed(ActionEvent e) {
		System.exit(0);
	}

	private void helpAbout_ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Asyncronous Processing Pattern!");
	}
}
