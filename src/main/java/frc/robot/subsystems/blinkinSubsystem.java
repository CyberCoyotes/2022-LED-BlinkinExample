/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class blinkinSubsystem extends SubsystemBase {

  /* Rev Robotics Blinkin takes a PWM signal from 1000-2000us
   * This is identical to a SparkMax motor. 
   *  -1  corresponds to 1000us
   *  0   corresponds to 1500us
   *  +1  corresponds to 2000us
   */
  private static Spark m_blinkin = null;

  /**
   * Creates a new Blinkin LED controller.
   * 
   * @param pwmPort  The PWM port the Blinkin is connected to.
   */
  public blinkinSubsystem(int pwmPort) {
    m_blinkin = new Spark(pwmPort);
    // Default
    // chase_red();
  }

  /*
   * Set the color and blink pattern of the LED strip.
   * 
   * Consult the Rev Robotics Blinkin manual Table 5 for a mapping of values to patterns.
   * 
   * @param val The LED blink color and patern value [-1,1]
   * 
   */ 
  public void set(double val) {
    if ((val >= -1.0) && (val <= 1.0)) {
      m_blinkin.set(val);
    }
  }

  public void rainbow() {
    set(-0.99);
  }
  
  public void oceanPallete () {
    set(-0.75);
  }

  public void wave_ocean () {
    set(-0.41);
  }
  
  public void chase_red() {
    set(-0.31);
  }

  public void chase_blue() {
    set(-0.29);
  }

  public void blend_to_black() {
    set(-0.03);
  }

  public void darkRed() {
    set(0.59);
  }
  
  public void gold() {
    set(0.67);
  }

  public void yellow() {
    set(0.69);
  }

  public void darkBlue() {
    set(0.85);
  }
 
  public void violet() {
    set(0.91);
  }

  public void allianceColor() {
    boolean isRed = NetworkTableInstance.getDefault().getTable("FMSInfo").getEntry("IsRedAlliance").getBoolean(true);
    if (isRed == true){
      RobotContainer.m_blinkin.chase_red();
      System.out.println("Red Alliance");
    } else {
      RobotContainer.m_blinkin.chase_blue();
      System.out.println("Blue Alliance");
    }
  }

  public void aprilTagID() {
    int aprilColor = 1; 

    if (aprilColor == 1) {
      RobotContainer.m_blinkin.violet();
      System.out.println("April Tag is 1");
    
    }
    if (aprilColor == 2) {
      RobotContainer.m_blinkin.gold();
      System.out.println("April Tag is 2");
    } 
    
  }

}
