package lwh.codeguide.video;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Pet{
	private String type;
	
	public Pet(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
}

class Dog extends Pet{
	public Dog(){
		super("dog");
	}
}

class Cat extends Pet{
	public Cat(){
		super("cat");
	}
}

public class CatDogQueue {

	private ArrayList<Pet> list = new ArrayList<>();
	
	public void add(Pet p){
		list.add(p);
	}
	
	public void pollAll(){
		Iterator<Pet> it = list.iterator();
		while(it.hasNext()){
			Pet pet = it.next();
			System.out.println(pet.getType() + pet.toString());
		}
		list = new ArrayList<>();
	}
	
	public void pollDog(){
		List<Pet> dog = new ArrayList<>();
		List<Pet> cat = new ArrayList<>();
		Iterator<Pet> it = list.iterator();
		while(it.hasNext()){
			Pet pet = it.next();
			if(pet instanceof Dog){
				dog.add(pet);
			}else{
				cat.add(pet);
			}
		}
		it = dog.iterator();
		while(it.hasNext()){
			Dog d = (Dog) it.next();
			System.out.println(d.getType() + d.toString());
		}
		list = (ArrayList<Pet>) cat;
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public boolean isDogEmpty(){
		boolean flag = true;
		Iterator<Pet> it = list.iterator();
		while(it.hasNext()){
			if("dog".equals(it.next().getType())){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		CatDogQueue c = new CatDogQueue();
		c.list.add(new Dog());
		c.list.add(new Cat());
		c.list.add(new Dog());
		c.list.add(new Cat());
		c.list.add(new Cat());
		c.list.add(new Dog());
		
		c.pollDog();
		System.out.println(c.isDogEmpty());
		System.out.println(c.isEmpty());
	}

}
