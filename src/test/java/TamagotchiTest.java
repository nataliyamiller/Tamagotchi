import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

@Test
public void Tamagotchi_instantiatesCorrectly_true() {
  Tamagotchi myTamagotchi = new Tamagotchi();
  assertEquals(true, myTamagotchi instanceof Tamagotchi);
}

@Test
public void Tamagotchi_isDead_false() {
  Tamagotchi myTamagotchi = new Tamagotchi();
  assertEquals(false, myTamagotchi.isDead());
}

@Test
public void Tamagotchi_hungerLevelMAX_true() {
  Tamagotchi testFullness = new Tamagotchi();
  assertEquals("Your Tamagotchi levels are: fullness 10, happiness 6, energy 3", testFullness.feed());
}

@Test
public void Tamagotchi_playLevelIncreases_true() {
  Tamagotchi testPlay = new Tamagotchi();
  assertEquals("Your Tamagotchi levels are: fullness 3, happiness 10, energy 3", testPlay.play());
}

@Test
public void Tamagotchi_restLevelMAX_true() {
  Tamagotchi testRest = new Tamagotchi();
  assertEquals("Your Tamagotchi levels are: fullness 4, happiness 7, energy 10", testRest.rest());
}
}