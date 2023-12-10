import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import javafx.scene.Node;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import java.util.Vector;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

//	 to test if the numbers are stored correctly for spot 1
	@Test
	void testStore1()
	{
		drawing draw = new drawing();

		Set a = new HashSet(1);
		a.add(1);
		draw.nums = a;
		assertEquals(draw.nums.size(),a.size());
		Iterator it = a.iterator();
		Iterator itr = draw.nums.iterator();
		while (it.hasNext() && itr.hasNext())
		{
			assertEquals(it.next(), itr.next());
		}
	}


	// to test if the numbers are stored correctly for spot 4
	@Test
	void testStore4()
	{
		drawing draw = new drawing();
		Set b = new HashSet(4);
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(4);
		draw.nums = b;
		assertEquals(draw.nums.size(),b.size());
		Iterator it = b.iterator();
		Iterator itr = draw.nums.iterator();
		while (it.hasNext() && itr.hasNext())
		{
			assertEquals(it.next(), itr.next());
		}
	}

	// to test if the numbers are stored correctly for spot 8
	@Test
	void testStore8()
	{
		drawing draw = new drawing();

		Set c = new HashSet(8);
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(6);
		c.add(73);
		c.add(75);
		c.add(80);
		c.add(35);
		draw.nums = c;
		assertEquals(draw.nums.size(),c.size());
		Iterator it = c.iterator();
		Iterator itr = draw.nums.iterator();
		while (it.hasNext() && itr.hasNext())
		{
			assertEquals(it.next(), itr.next());
		}
	}

	// to test if the numbers are stored correctly for spot 10
	@Test
	void testStore10()
	{
		drawing draw = new drawing();

		Set d = new HashSet(10);
		d.add(1);
		d.add(2);
		d.add(3);
		d.add(6);
		d.add(73);
		d.add(75);
		d.add(80);
		d.add(35);
		d.add(40);
		d.add(45);
		draw.nums = d;
		assertEquals(draw.nums.size(),d.size());
		Iterator it = d.iterator();
		Iterator itr = draw.nums.iterator();
		while (it.hasNext() && itr.hasNext())
		{
			assertEquals(it.next(), itr.next());
		}
	}

	// Test case for Spot 1 with 1 match
	@Test
	void Spot1Match1(){
		int spot = 1;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(1);
		num.add(15);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(77);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(62);
		checkNum.add(9);
		checkNum.add(6);

		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(),spot);
		}
		assertEquals(2,draw.getSum());
	}

	// Test case for spot 4 with 4 matches
	@Test
	void Spot4Match4() {
		int spot = 4;
		drawing a = new drawing();
		a.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(4);
		num.add(10);
		num.add(20);
		num.add(30);
		num.add(40);
		a.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(75, a.getSum());
	}

	// Test case for Spot 8 with no matches
	@Test
	void Spot8Match0() {

		int spot = 8;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(8);
		num.add(15);
		num.add(4);
		num.add(23);
		num.add(21);
		num.add(25);
		num.add(43);
		num.add(23);
		num.add(54);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(0, draw.getSum());
	}

	// Test case for Spot 8 with 5 matches
	@Test
	void Spot8Match5() {

		int spot = 8;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(8);
		num.add(15);
		num.add(4);
		num.add(23);
		num.add(21);
		num.add(25);
		num.add(43);
		num.add(23);
		num.add(54);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(23);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(21);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(54);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(4);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(12, draw.getSum());
	}

	// Test case for spot 10 with 3 matches
	@Test
	void Spot10Match3() {
		int spot = 10;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(10);
		num.add(15);
		num.add(4);
		num.add(23);
		num.add(21);
		num.add(25);
		num.add(43);
		num.add(23);
		num.add(54);
		num.add(24);
		num.add(65);

		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(0, draw.getSum());
	}

	// Test case for spot 8 with 6 matches
	@Test
	void Spot8Match6() {
		int spot = 8;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(8);
		num.add(15);
		num.add(5);
		num.add(23);
		num.add(21);
		num.add(25);
		num.add(45);
		num.add(20);
		num.add(55);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(50, draw.getSum());
	}

	// Test case for spot 10 with no matches
	@Test
	void Spot10Match0() {
		int spot = 10;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(10);
		num.add(16);
		num.add(4);
		num.add(23);
		num.add(21);
		num.add(28);
		num.add(43);
		num.add(23);
		num.add(54);
		num.add(24);
		num.add(67);

		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(5, draw.getSum());
	}

	// Test case for spot 10 with 7 matches
	@Test
	void Spot10Match7() {
		int spot = 10;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(10);
		num.add(16);
		num.add(4);
		num.add(23);
		num.add(21);
		num.add(28);
		num.add(43);
		num.add(23);
		num.add(54);
		num.add(24);
		num.add(67);

		draw.nums = num;
		checkNum.add(16);
		checkNum.add(21);
		checkNum.add(30);
		checkNum.add(4);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(24);
		checkNum.add(35);
		checkNum.add(43);
		checkNum.add(54);
		checkNum.add(67);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(40, draw.getSum());
	}

	// Test case for spot 10 with 8 matches
	@Test
	void Spot10Match6() {
		int spot = 10;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(10);
		num.add(15);
		num.add(5);
		num.add(20);
		num.add(21);
		num.add(25);
		num.add(45);
		num.add(23);
		num.add(55);
		num.add(70);
		num.add(60);

		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(450, draw.getSum());
	}

	// Test case for spot 4 with no matches
	@Test
	void Spot4Match0() {
		int spot = 4;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(4);
		num.add(19);
		num.add(4);
		num.add(23);
		num.add(21);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(0, draw.getSum());
	}

	// Test case for spot 1 with no matches
	@Test
	void Spot1Match0() {
		int spot = 1;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(1);
		num.add(18);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(0, draw.getSum());
	}

	// Test case for Spot 4 with 2 matches
	@Test
	void Spot4match2() {
		int spot = 4;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(4);
		num.add(15);
		num.add(4);
		num.add(20);
		num.add(21);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(1, draw.getSum());
	}

    // Test case spot 4 with 3 matches
	@Test
	void Spot4Match3() {
		int spot = 4;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(4);
		num.add(15);
		num.add(40);
		num.add(1);
		num.add(25);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(5, draw.getSum());
	}

	// Test case for Spot 10 with 10 matches
	@Test
	void Spot10Match10() {
		int spot = 10;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(10);
		num.add(15);
		num.add(5);
		num.add(20);
		num.add(60);
		num.add(25);
		num.add(45);
		num.add(30);
		num.add(55);
		num.add(70);
		num.add(65);

		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(100000, draw.getSum());
	}

	// Test case for spot 8 with 8 matches
	@Test
	void Spot8Match8() {
		int spot = 8;
		drawing draw = new drawing();
		draw.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(8);
		num.add(15);
		num.add(5);
		num.add(70);
		num.add(20);
		num.add(35);
		num.add(45);
		num.add(25);
		num.add(55);
		draw.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			draw.logic(value.intValue(), spot);
		}
		assertEquals(10000, draw.getSum());
	}

	// Test case for spot 1 when the number of drawing is 2
	@Test
	void Spot1Drawing2() {
		int spot = 1;
		drawing a = new drawing();
		a.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(1);
		num.add(10);
		a.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(85);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(2, a.getSum());
		a.reset();

		Set checkNum1 = new HashSet(20);
		checkNum1.add(3);
		checkNum1.add(13);
		checkNum1.add(23);
		checkNum1.add(33);
		checkNum1.add(43);
		checkNum1.add(53);
		checkNum1.add(63);
		checkNum1.add(73);
		checkNum1.add(2);
		checkNum1.add(12);
		checkNum1.add(22);
		checkNum1.add(32);
		checkNum1.add(42);
		checkNum1.add(52);
		checkNum1.add(62);
		checkNum1.add(72);
		checkNum1.add(10);
		checkNum1.add(11);
		checkNum1.add(21);
		checkNum1.add(31);
		assertEquals(20, checkNum1.size());
		Iterator it = checkNum1.iterator();
		while (it.hasNext()) {
			Integer value = (Integer) it.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(2, a.getSum());
		assertEquals(4, a.getTotalSum());
	}

	// Test case for spot 4 when the number of drawing is 2
	@Test
	void Spot4Drawing2() {
		int spot = 4;
		drawing a = new drawing();
		a.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(4);
		num.add(10);
		num.add(20);
		num.add(30);
		num.add(40);
		a.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(8);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(75, a.getSum());
		a.reset();

		Set checkNum1 = new HashSet(20);
		checkNum1.add(3);
		checkNum1.add(13);
		checkNum1.add(23);
		checkNum1.add(33);
		checkNum1.add(43);
		checkNum1.add(53);
		checkNum1.add(63);
		checkNum1.add(73);
		checkNum1.add(2);
		checkNum1.add(12);
		checkNum1.add(22);
		checkNum1.add(32);
		checkNum1.add(42);
		checkNum1.add(52);
		checkNum1.add(62);
		checkNum1.add(72);
		checkNum1.add(10);
		checkNum1.add(11);
		checkNum1.add(21);
		checkNum1.add(30);
		assertEquals(20, checkNum1.size());
		Iterator it = checkNum1.iterator();
		while (it.hasNext()) {
			Integer value = (Integer) it.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(1, a.getSum());
		assertEquals(76, a.getTotalSum());
	}

	// Test case for spot 8 when the number of drawing is 2
	@Test
	void Spot8Drawing2() {
		int spot = 8;
		drawing a = new drawing();
		a.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(8);
		num.add(10);
		num.add(26);
		num.add(30);
		num.add(40);
		num.add(17);
		num.add(5);
		num.add(39);
		num.add(47);
		a.nums = num;

		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(8);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(2, a.getSum());
		a.reset();

		Set checkNum1 = new HashSet(20);
		checkNum1.add(3);
		checkNum1.add(13);
		checkNum1.add(26);
		checkNum1.add(33);
		checkNum1.add(43);
		checkNum1.add(53);
		checkNum1.add(63);
		checkNum1.add(73);
		checkNum1.add(2);
		checkNum1.add(12);
		checkNum1.add(22);
		checkNum1.add(30);
		checkNum1.add(42);
		checkNum1.add(52);
		checkNum1.add(62);
		checkNum1.add(72);
		checkNum1.add(10);
		checkNum1.add(11);
		checkNum1.add(21);
		checkNum1.add(39);
		assertEquals(20, checkNum1.size());
		Iterator it = checkNum1.iterator();
		while (it.hasNext()) {
			Integer value = (Integer) it.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(2, a.getSum());
		assertEquals(4, a.getTotalSum());
	}

	// Test case for spot 10 when the number of drawing is 2
	@Test
	void Spot10Drawing2() {
		int spot = 10;
		drawing a = new drawing();
		a.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(10);
		num.add(10);
		num.add(26);
		num.add(30);
		num.add(40);
		num.add(17);
		num.add(5);
		num.add(39);
		num.add(47);
		num.add(4);
		num.add(1);
		a.nums = num;

		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(4);
		checkNum.add(9);
		checkNum.add(6);
		assertEquals(20, checkNum.size());
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(2, a.getSum());
		a.reset();

		Set checkNum1 = new HashSet(20);
		checkNum1.add(3);
		checkNum1.add(13);
		checkNum1.add(23);
		checkNum1.add(33);
		checkNum1.add(43);
		checkNum1.add(53);
		checkNum1.add(63);
		checkNum1.add(73);
		checkNum1.add(2);
		checkNum1.add(12);
		checkNum1.add(22);
		checkNum1.add(32);
		checkNum1.add(42);
		checkNum1.add(52);
		checkNum1.add(62);
		checkNum1.add(72);
		checkNum1.add(14);
		checkNum1.add(11);
		checkNum1.add(21);
		checkNum1.add(31);
		assertEquals(20, checkNum1.size());
		Iterator it = checkNum1.iterator();
		while (it.hasNext()) {
			Integer value = (Integer) it.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(5, a.getSum());
		assertEquals(7, a.getTotalSum());
	}

	// to check if the function TwentyNumbers prints 20 values
	@Test
	void testTwenty() {
		JavaFXTemplate test = new JavaFXTemplate();
		assertEquals(20, test.TwentyNumbers().size());
	}

	// Test case to check if the reset function works
	@Test
	void testReset() {
		int spot = 4;
		drawing a = new drawing();
		a.addingValues();
		Set checkNum = new HashSet(20);
		Set num = new HashSet(4);
		num.add(10);
		num.add(20);
		num.add(30);
		num.add(40);

		a.nums = num;
		checkNum.add(10);
		checkNum.add(20);
		checkNum.add(30);
		checkNum.add(40);
		checkNum.add(50);
		checkNum.add(60);
		checkNum.add(70);
		checkNum.add(80);
		checkNum.add(90);
		checkNum.add(5);
		checkNum.add(15);
		checkNum.add(25);
		checkNum.add(35);
		checkNum.add(45);
		checkNum.add(55);
		checkNum.add(65);
		checkNum.add(75);
		checkNum.add(8);
		checkNum.add(9);
		checkNum.add(6);
		Iterator itr = checkNum.iterator();
		while (itr.hasNext()) {
			Integer value = (Integer) itr.next();
			a.logic(value.intValue(), spot);
		}
		assertEquals(75, a.sum);
		assertEquals(4, a.count);
		assertEquals(20, a.c);

		a.reset();

		assertEquals(0, a.sum);
		assertEquals(0, a.count);
		assertEquals(0, a.c);
	}
}
