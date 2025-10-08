

public class OOPS {
    public static void main(String[] args) {
    //     Pen p1=new Pen();
    //     p1.setColor("Blue");
    //     System.out.println(p1.color);
    //     p1.setTip(10);
    //     System.out.println(p1.tip);
    //    p1.color="purple";
    //     System.out.println(p1.color);
    

//     BankAccount acc1= new BankAccount();
//    acc1.username="Aniston Breganza";
// //    acc1.password="abjsk1nas3";
//        //not possible as it is private so funcn is created 
//     acc1.setPassword("absd2dsa2");


    // Book b1= new Book();
    // b1.setColor("blue");
    // System.out.println(b1.getColor());
    // b1.setPages(70);
    // System.out.println(b1.getPages());
    // b1.setColor("Pink");
    // System.out.println(b1.getColor());


    // Student s1= new Student("Shraddha", 12);
    // System.out.println(s1.name + " " + s1.standard);
    // OR
    // Student s1= new Student();


    // copy constructor topic
// School s1= new School();
// s1.name="Asian";
// s1.sclno=233;
// s1.password="ads d";
// s1.marks[0]=100;
// s1.marks[1]=80;
// s1.marks[2]=70;

// School s2= new School(s1);
// s2.password="afsc";
// s1.marks[2]=100;
// for(int i=0; i<3;i++){
//   System.out.println("marks are: "+s2.marks[i]);  
// }
// System.out.println("name of school: "+s1.name);

// inheritance 
// Fish shark= new Fish();
// shark.eat();
// shark.fins=6;
// System.out.println(shark.fins);


// polymorphism
// method overloading or function overloading. Compile time polymorphism:where complier known which function is going to get compiled while calling that function dring compile time here while calling int sum function(a,b parameter) complier knows which funcn needs to be executed
// Calculator calc= new Calculator();
// System.out.println(calc.sum(1,2));
// System.out.println(calc.sum((float)1.5,(float)2.5));
// System.out.println(calc.sum(1,2,7));

// // method overriding or function overloading. Run time polymorphism and  class object is created and then it calss accordingly.
// Alcohol alc= new Alcohol();
// alc.bitter();
// Wine w= new Wine();
// w.bitter();


// Abstracion
// if we make object of animalia it will throw an error bcoz we can't create object while using abstract class 
// though child object can be created it doesn't use abstract class
// Horse h= new Horse();
// h.eat();
// h.walk();

// here constructor is used and brown is the output unless we call changeColor funcn even though we are accessing horse here. It is becoz horse is a child of Animalia and in case of constructors always the output will follow hierarchy i.e. parent class will be called first follwed by the subclasses.
// System.out.println(h.color);

// Chick c= new Chick();
// c.eat();
// c.walk();

// Use of constructor in hierarchial order(Animalia->Horse->Mustang).
// Mustang m= new Mustang();
// Output will be : first animalia then horse then mustang con. is called


// interface
// Queen q= new Queen();
// q.moves();
// King k= new King();
// k.moves();


// static : here if property and function is static i.e. it will apply to each object of that class
Office o1= new Office();
o1.OfficeBranch="bengaluru";
Office o2= new Office();
System.out.println(o2.OfficeBranch);


// super: first constructors will be called (parent) then the other properties. By defsult java applies super class in case it is not selected.
Salamander s= new Salamander();
System.out.println(s.skin);
}
}

// class Pen{
//     String color;
//     int tip;
//     void setColor(String newColor){
//         color=newColor;
//     }
//     void setTip(int newTip){
//         tip=newTip;
//     }
// }

// using get and set 
// class Book{
//     String name;
//     private String color;
//     private int pages;
    
//     String getName(){
//         return this.name;
//     }
//     String getColor(){
//         return this.color;
//     }
//     int getPages(){
//         return this.pages;
//     }
//     void setColor(String newColor){
//         this.color=newColor;
//     }
//     void setPages(int newPages){
//         this.pages=newPages;
//     }
// }


// class BankAccount{
//     public String username;
//     private String password;
//     public void setPassword(String pwd){
//         password=pwd;
//     }
// }

// class Student{
//     String name;
//     int standard;
//     float percentage;
//     void calPercentage(int phy, int chem, int bio){
//         percentage=(phy+chem+bio)/3;
//     }


// CONSTRUCTOR
    // parameterised constructor passing parameters
        // Student(String name, int standard){
        //     this.name= name;
        //     this.standard= standard;
        // }
        // OR

// non-parameterized constructor
    // Student(){
        //     System.out.println("Constructor is made.");
        // }
    // }
        // copy constructor
        class School{
            String name;
            int sclno;
            String password;
            int marks[];
// copy constructor
            School(School s1){
                marks=new int[3];
                this.name= s1.name;
                this.sclno=s1.sclno;
                this.marks= s1.marks;
            }
            School(){
                marks=new int[3];
            }
            School(String name){
                marks=new int[3];
                this.name=name;
            }             
            }
        
        // destructor: automatically removes the class which is not in use for a long time.

        // inheritance :properties passing from parent or base class to its child or derived class
// base class parent
        // class Animal{
        //     String color;
        //     void eat(){
        //         System.out.println("eat");
        //     }
        //     void breathe(){
        //         System.out.println("breathe");
        //     }
        // }

        // derivd classs child use of extends
        // class Fish extends Animal{
        //     int fins;
        // }

        // heirerchial class
        // class Fishe extends Animal{
        //     int fins;
        //     void swim(){
        //         System.out.println("swim");
        //     }
        // }
        // class Dog extends Animal{
        //    void  walk(){
        //     System.out.println("walk");
        //     }
        // }
        // class Bird extends Animal{
        //     void fly(){
        //      System.out.println("fly");
        //      }
        //  }

    // multilevel inheritance
//     class Mammals extends Animal{
//    int legs;
//         }

//     class Dogs extends Mammals{
//         String breed;
//     }

    // hybrid inheritance
    // class Fishes extends Animal{
    //   int gills;
    // }
    // class Tuna extends Fishes{
    //     String properties;
    // }
    // class Seahorse extends Fishes{
    //     String fertility;
    // }

    // class Birdie extends Animal{
    //     int beak;
    //   }
    //   class Eagle extends Birdie{
    //       String feathers;
    //   }
    //   class Woodpecker  extends Birdie{
    //       String feathers;
    //   }

    //   class Amphibians extends Animal{
    //     String heart;
    //   }
    //   class Salamander extends Amphibians{
    //       String body;
    //   }
    //   class Toad extends Amphibians{
    //       String color;
    //   }


    //   Polymorphism
    // Method overloading: same function name with different parameter
    // class Calculator{
    //     int sum(int a, int b){
    //         return a+b;
    //     }
    //     float sum(float a, float b){
    //         return a+b;
    //     }
    //     int sum(int a, int b,int c){
    //         return a+b+c;
    //     }
    
    // }

    // Method overriding where parent and chile both have same function and same parameter but have different definition
    // class Alcohol{
    //     void bitter(){
    //         System.out.println("bitter in taste");
    //     }
    // }
    // class Wine extends Alcohol{
    //     void bitter(){
    //         System.out.println("bitter and sweet");
    //     }
    // }


    // Abstraction: hiding all unnecessary details and showing only imporant part of the user, it also gives the idea to use but doesn't implement it  while encapsulation hides the imporrtant data and protects it.
    // Abstract class: while using abstract in a class it means that we are not making the object 2. we can create function as abstract 
    // abstract class  Animalia {
    //     String color;
    // void eat(){
    //     System.out.println("Eatss");
    // }

    // abstract classes uses constructor. Constructor helps in calling the function from abstract funcn which was not possible initally 
    // Animalia(){
    //     System.out.println("Animal constructor is called.");
    //     color= "brown";
    // }

    //     abstract void walk();
        // here we can't print under walk function since its an abstract function and it is giving an idea to its subclasses to walk and not implementing it. It will show an error if we try to print in walk function.
    // }
    //  class Horse extends Animalia{
        // here it is important to write walk function otherwise throws an error actual implementation is done in child class 
    //     void walk(){
    //         System.out.println("Walks in 4 legs");
    //     }
    //     void changeColor(){
    //        color="Dark brown";
    //     }
    //     // constructor of horse 
    //     Horse(){
    //         System.out.println("Horse constructor called");
    //     }
    //  }
    //  class Mustang extends Horse{
    //     Mustang(){
    //         System.out.println("Mustang constructor called");
        
    //     }
    //  }

    //  class Chick extends Animalia{
    //     void changeColor(){
    //         color="yellow";
    //     }
    //     void walk(){
    //         System.out.println("Walks in 2 legs");
    //     }
    //  }


    //  interfaces: it is a blueprint of the class and class is a blueprint of object. It provides multiple ineritance and total abstraction to the  class i.e. unlike abstraction(where its a choice to make abstract class or not), while using interface keyword automically abstraction is applied to all methods(properties) or funcn.
    // implements keyword is used instead of extends.
    // all methods are public abstract and without implementation(as we know abstract class doesn't implement , it only gives idea.)
    // variables in interface are final(the value is fixed), public and static( since static is onluy used for classes and not obejcts)
// interface ChessPLayer{
//     void moves();
// }
// class Queen implements ChessPLayer{
//     // impt. to right public in function when using interface otherwise it will take it as default i.e. as an abstract( non-functionable)
//     public void moves(){
//         System.out.println("up, down, left, right, diagonal(all dimension)");
//     }
// }
// class King implements ChessPLayer{
//     public void moves(){
//         System.out.println("up, down, left, right, diagonal(1 step)");
//     }
// }

// interface Herbivore{
// void eats();
// }
// interface Carnivore{
// void eats();
// }
// class Bear implements Herbivore,Carnivore{
// public void eats(){ 
//     System.out.println("eats both flesh and grass");
// }
// }

// static keyword :is used when a method or properties are same for multiple objects withi the same class
class Office{
    static int returnPercentage(int math, int phy, int chem){
        return(math+phy+chem)/3;
    }
    String name;
    int Id;
    static String OfficeBranch;
    void setName(String name){
        this.name= name;
    }
    String getName(String name){
        return this.name=name;
    }
}

// super keyword: used to access parent's properties, function, constructor
class Reptilia{
    String skin;
    Reptilia(){
    System.out.println("R constructor called");
}
}
class Salamander extends Reptilia{
    Salamander(){
        super.skin="dry";
        System.out.println("S constructor called");
    }
}