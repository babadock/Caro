package com.example.caro;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CaroApp extends ActionBarActivity {

	private Button mBoardButton[];
	private CaroGame nGame;
	private boolean mGameOver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caro_app);
		nGame = new CaroGame();
		mBoardButton = new Button[nGame.getBOARD_SIZE()];
		mBoardButton[0] = (Button) findViewById(R.id.one);
		mBoardButton[1] = (Button) findViewById(R.id.two);
		mBoardButton[2] = (Button) findViewById(R.id.three);
		mBoardButton[3] = (Button) findViewById(R.id.four);
		mBoardButton[4] = (Button) findViewById(R.id.five);
		mBoardButton[5] = (Button) findViewById(R.id.six);
		mBoardButton[6] = (Button) findViewById(R.id.seven);
		mBoardButton[7] = (Button) findViewById(R.id.eight);
		mBoardButton[8] = (Button) findViewById(R.id.nine);

		startNewGame();
	}

	private void startNewGame() {
		nGame.clearBoard();
		for (int i = 0; i < nGame.getBOARD_SIZE(); i++) {
			mBoardButton[i].setText("");
			mBoardButton[i].setEnabled(true);
			mBoardButton[i].setOnClickListener(new ButtonClickListener(i));
		}
		// player always move first
		int move = nGame.getComputerMove();
		setMove(nGame.ANDROID_PLAYER, move);
	}

	private class ButtonClickListener implements View.OnClickListener {
		int location;

		public ButtonClickListener(int location) {
			this.location = location;
		}

		public void onClick(View v) {
			if (!mGameOver) {
				if (mBoardButton[location].isEnabled()) {
					setMove(nGame.HUMAN_PLAYER, location);
					int winner = nGame.checkForWinner();

					if (winner == 0) {
						int location = nGame.getComputerMove();
						setMove(nGame.ANDROID_PLAYER, location);
						winner = nGame.checkForWinner();
					}
					if (winner == 0)
						return;
					else if (winner == 1) {
						mGameOver = true;
					} else if (winner == 2) {
						mGameOver = true;
					} else {
						mGameOver = true;
					}
				}
			}

		}
	}

	private void setMove(char player, int location) {
		nGame.setMove(player, location);
		mBoardButton[location].setEnabled(false);
		mBoardButton[location].setText(String.valueOf(player));
		if (player == nGame.HUMAN_PLAYER)
			mBoardButton[location].setTextColor(Color.GREEN);
		else
			mBoardButton[location].setTextColor(Color.RED);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.caro_app, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}














