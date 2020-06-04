package com.example.android.xmenadventure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ScenarioOnec extends AppCompatActivity {

    //Initializes the variables that will be used.
    TextView error_message;
    TextView attack_button1c;
    TextView attack_button2c;
    TextView attack_button3c;
    TextView end_battle;
    TextView retry_battle;
    TextView sentinel_attack;

    // Initializes villain's health.
    int sentinelHealth = 15;

    // Initializes hero's health.
    int heroHealth = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenario_onec);

        // This line of code links the error message code with the TextView in the XML file.
        error_message = findViewById(R.id.error_message);

        // These three lines of codes link the three attack buttons in XML file to Java program.
        attack_button1c = findViewById(R.id.attack_button1c);
        attack_button2c = findViewById(R.id.attack_button2c);
        attack_button3c = findViewById(R.id.attack_button3c);

        // Links to end battle button and hides visibility immediately to prevent user from seeing it.
        end_battle = findViewById(R.id.end_battle);
        end_battle.setVisibility(View.INVISIBLE);

        // Links to end battle button and hides visibility immediately to prevent user from seeing it.
        sentinel_attack = findViewById(R.id.sentinel_attack);
        sentinel_attack.setVisibility(View.INVISIBLE);

        // Links to villain's attack button and hides visibility until it needs to return.
        retry_battle = findViewById(R.id.retry_battle);
        retry_battle.setVisibility(View.INVISIBLE);

    }

    // This function displays the hero's health and establishes a string value that can be manipulated.
    public void displayHeroHealth(int healthy) {
        TextView healthyView = findViewById(R.id.hero_health);
        healthyView.setText(String.valueOf(healthy));

    }

    // This function displays the villain's health and establishes a different string value that can be manipulated.
    public void displaySentinelHealth (int health) {
        TextView healthView = findViewById(R.id.sentinel_health);
        healthView.setText(String.valueOf(health));
    }

    // This function switches the attack buttons to become interactive.
    public void onButton(){
        attack_button1c.setEnabled(true);
        attack_button2c.setEnabled(true);
        attack_button3c.setEnabled(true);
    }

    // This function switches the attack buttons off and renders them non-interactive.
    public void offButton(){
        attack_button1c.setEnabled(false);
        attack_button2c.setEnabled(false);
        attack_button3c.setEnabled(false);
    }

    // This function drives the attack mechanic for the villain.
    public void sentinelAttack(View v) {

        // This establishes a number generator (from 1 to 10) that dictates the action of the villain's attack.
        Random s = new Random();
        int numb = s.nextInt(11);

        // This piece of conditional code allows the following action to be performed if random
        // number is 6 or greater AND hero's health has not reached 0.
        if (numb >= 8 && heroHealth != 0) {

            // Once both conditions are met, the hero's health value is reduced by 1 and it's new value is
            // displayed to user. Error message activated from a different function becomes invisible.
            heroHealth = heroHealth - 1;
            displayHeroHealth(heroHealth);
            error_message.setVisibility(View.INVISIBLE);


        } else {

            // If both conditions are not met, the error message is displayed to user.
            error_message.setVisibility(View.VISIBLE);
            error_message.setText("The Sentinel has missed! Strike Now!");

            // Hero's attack buttons are now interactive again to user.
            onButton();

            // This statement ensures that this +3 attack button is not interactive if villain
            // health less than 3.
            if (sentinelHealth < 3){

                attack_button1c.setEnabled(false);
            }

            // This statement ensures that this +2 attack button is not interactive if villain
            // health less than 2.
            if (sentinelHealth < 2) {

                attack_button2c.setEnabled(false);
            }

            // Villain's attack button is no longer visible to user.
            sentinel_attack.setVisibility(View.INVISIBLE);

        }

        if (heroHealth == 0) {

            // This initiates a zero addition action to complete the function's activity.
            sentinelHealth = sentinelHealth + 0;

            // Turns off attack buttons and renders them non-interactive.
            offButton();

            // This line of code activates a Game Over message and allows the user to see and interact with a retry button.
            error_message.setText("You have been defeated! Try again?");
            error_message.setVisibility(View.VISIBLE);
            retry_battle.setVisibility(View.VISIBLE);

            sentinel_attack.setVisibility(View.INVISIBLE);

        }
    }

    // This function activates a number of actions that react to the user's interaction with the button.
    public void attackOnec (View v) {

        // Generates another random number generator (1 to 20) to start certain actions.
        Random r = new Random();
        int num = r.nextInt(21);

        // This makes the villain's attack button not visible to user.
        sentinel_attack.setVisibility(View.INVISIBLE);

        // This condition is activated if the random is 17 or greater AND if
        // the villain's health is greater 0 OR greater than or equal to 3.
        if (num >= 17 && (sentinelHealth > 0 || sentinelHealth >= 3)) {

            // If conditions met, the villain's health will decline by 3 and redisplayed with new value.
            // The error message also disappears.
            sentinelHealth = sentinelHealth - 3;
            displaySentinelHealth(sentinelHealth);
            error_message.setVisibility(View.INVISIBLE);

        } else {

            // If conditions are not met, the error message can be seen by user.
            error_message.setVisibility(View.VISIBLE);
            error_message.setText("This attack missed!");

            // This deactivates interactiveness of attack buttons to user.
            offButton();

            sentinel_attack.setVisibility(View.VISIBLE);

        }

        // This condition is activated if villain's health is less than 3.
        if (sentinelHealth < 3) {

            // An error message will be visible to user.
            sentinelHealth = sentinelHealth + 0;
            attack_button1c.setEnabled(false);

            // The villain's health will increase by 0 and deactivates the attack button to user.
            error_message.setText("Try a different attack!");
            error_message.setVisibility(View.VISIBLE);

        } else {

        }

        // If villain's health is 0, this series of actions will be activated.
        if (sentinelHealth == 0) {

            error_message.setVisibility(View.INVISIBLE);
            error_message.setVisibility(View.VISIBLE);
            error_message.setText("The enemy is defeated!");

            // Attack buttons will be turned off and non-interactive to user.
            offButton();

            // End battle button will be viewable and interactive to user.
            end_battle.setVisibility(View.VISIBLE);

          // If previous condition not reached, the actions will be bypassed and the villain's health
          // will be displayed
        } else {
            displaySentinelHealth(sentinelHealth);
        }
    }

    // This function activates a number of actions that react to the user's interaction with the button.
    public void attackTwoc (View v) {

        // Generates another random number generator (1 to 20) to start certain actions.
        Random r = new Random();
        int num = r.nextInt(21);

        // This makes the villain's attack button not visible to user.
        sentinel_attack.setVisibility(View.INVISIBLE);

        // This condition is activated if the random is 11 or greater AND if
        // the villain's health is greater 0 OR greater than or equal to 2.
        if (num >= 11 && (sentinelHealth > 0 || sentinelHealth >= 2)) {

            // If conditions met, the villain's health will decline by 2 and redisplayed with new value.
            // The error message also disappears.
            sentinelHealth = sentinelHealth - 2;
            displaySentinelHealth(sentinelHealth);
            error_message.setVisibility(View.INVISIBLE);

        } else {

            // If conditions are not met, the error message can be seen by user.
            error_message.setVisibility(View.VISIBLE);
            error_message.setText("This attack missed!");

            // This deactivates interactiveness of attack buttons to user.
            offButton();

            sentinel_attack.setVisibility(View.VISIBLE);

        }

        // This condition is activated if villain's health is less than 2.
        if (sentinelHealth < 2) {

            // An error message will be visible to user.
            error_message.setText("Try a different attack!");
            sentinelHealth = sentinelHealth + 0;

            // The villain's health will increase by 0 and deactivates the attack button to user.
            error_message.setVisibility(View.VISIBLE);
            attack_button2c.setEnabled(false);

        } else {

        }

        // If villain's health is 0, this series of actions will be activated.
        if (sentinelHealth == 0) {

            error_message.setVisibility(View.INVISIBLE);
            error_message.setVisibility(View.VISIBLE);
            error_message.setText("The enemy is defeated!");

            // Attack buttons will be turned off and non-interactive to user.
            offButton();

            // End battle button will be viewable and interactive to user.
            end_battle.setVisibility(View.VISIBLE);

          // If previous condition not reached, the actions will be bypassed and the villain's health
          // will be displayed.
        } else {
            displaySentinelHealth(sentinelHealth);
        }
    }

    // This function activates a number of actions that react to the user's interaction with the button.
    public void attackThreec (View v) {

        // Generates another random number generator (1 to 20) to start certain actions.
        Random r = new Random();
        int num = r.nextInt(21);

        // This makes the villain's attack button not visible to user.
        sentinel_attack.setVisibility(View.INVISIBLE);

        // This condition is activated if the random is 3 or greater AND if
        // the villain's health is greater 0 OR greater than or equal to 1.
        if (num >= 3 && (sentinelHealth > 0 || sentinelHealth >=1)) {

            // If conditions met, the villain's health will decline by 1 and redisplayed with new value.
            // The error message also disappears.
            sentinelHealth = sentinelHealth - 1;
            displaySentinelHealth(sentinelHealth);
            error_message.setVisibility(View.INVISIBLE);

        } else {

            // If conditions are not met, the error message can be seen by user.
            error_message.setVisibility(View.VISIBLE);
            error_message.setText("This attack missed!");

            // This deactivates interactiveness of attack buttons to user.
            offButton();

            sentinel_attack.setVisibility(View.VISIBLE);

        }

        // This condition is activated if villain's health is less than 1.
        if (sentinelHealth < 1) {

            // The villain's health will increase by 0 and deactivates the attack button to user.
            error_message.setText("Try a different attack!");
            sentinelHealth = sentinelHealth + 0;
            error_message.setVisibility(View.VISIBLE);
            attack_button3c.setEnabled(false);

        } else {

        }

        // If villain's health is 0, this series of actions will be activated.
        if (sentinelHealth == 0) {

            error_message.setVisibility(View.INVISIBLE);
            error_message.setVisibility(View.VISIBLE);
            error_message.setText("The enemy is defeated!");

            // Attack buttons will be turned off and non-interactive to user.
            offButton();

            // End battle button will be viewable and interactive to user.
            end_battle.setVisibility(View.VISIBLE);

          // If previous condition not reached, the actions will be bypassed and the villain's health
          // will be displayed.
        } else {
            displaySentinelHealth(sentinelHealth);
        }
    }

    // This function enables this activity to shift to the Intermission Screen upon interaction with button.
    public void nextBattlec (View v) {

        Intent intent = new Intent(ScenarioOnec.this, ScenarioTwoc.class);
        startActivity(intent);

    }

    // This function enables this activity to shift to the Home Screen upon interaction with button.
    public void retryBattle(View v) {

        Intent intent = new Intent(ScenarioOnec.this, HomeScreen.class);
        startActivity(intent);
    }
}
