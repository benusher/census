package com.ponchonog.census

import scala.util.Random

object Census {

  private val boysFirstNames: Set[String] = Set(
    "Oliver", "Jack", "Harry", "Jacob", "Charlie", "Thomas", "Oscar", "William", "James", "George", "Alfie", "Joshua", "Noah", "Ethan",
    "Muhammad", "Archie", "Leo", "Henry", "Joseph", "Samuel", "Riley", "Daniel", "Mohammed", "Alexander", "Max", "Lucas", "Mason",
    "Logan", "Isaac", "Benjamin", "Dylan", "Jake", "Edward", "Finley", "Freddie", "Harrison", "Tyler", "Sebastian", "Zachary", "Adam",
    "Theo", "Jayden", "Arthur", "Toby", "Luke", "Lewis", "Matthew", "Harvey", "Harley", "David", "Ryan", "Tommy", "Michael", "Reuben",
    "Nathan", "Blake", "Mohammad", "Jenson", "Bobby", "Luca", "Charles", "Frankie", "Dexter", "Kai", "Alex", "Connor", "Liam", "Jamie",
    "Elijah", "Stanley", "Louie", "Jude", "Callum", "Hugo", "Leon", "Elliot", "Louis", "Theodore", "Gabriel", "Ollie", "Aaron", "Frederick",
    "Evan", "Elliott", "Owen", "Teddy", "Finlay", "Caleb", "Ibrahim", "Ronnie", "Felix", "Aiden", "Cameron", "Austin", "Kian", "Rory",
    "Seth", "Robert", "Albert", "Sonny", "Rhys", "Joey", "Ellis", "Kayden", "Joel", "Jackson", "John", "Muhammed", "Dominic", "Kaiden",
    "Jasper", "Billy", "Bailey", "Maxwell", "Ayaan", "Finn", "Bradley", "Taylor", "Yusuf", "Kyle", "Reggie", "Olly", "Cody", "Rowan",
    "Tobias", "Patrick", "Nathaniel", "Sam", "Carter", "Hayden", "Corey", "Christopher", "Roman", "Eli", "Filip", "Alfred", "Ali",
    "Tristan", "Albie", "Ben", "Jesse", "Nicholas", "Aidan", "Zac", "Reece", "Rocco", "Jaxon", "Anthony", "Ashton", "Leighton",
    "Morgan", "Jakub", "Flynn", "Andrew", "Jason", "Ruben", "Syed", "Ralph", "Milo", "Spencer", "Cole", "Ahmed", "Vincent", "Zack",
    "Brandon", "Levi", "Jonathan", "Kacper", "Abdullah", "Brody", "Jonah", "Xavier", "Mohamed", "Marcus", "Beau", "Layton", "Kevin",
    "Myles", "Ted", "Miles", "Zak", "Peter", "Maximilian", "Jensen", "Alan", "Marley", "Abdul", "Oskar", "Arlo", "Kieran", "Musa",
    "Ewan", "Lukas", "Joe", "Maximus", "Leonardo", "Rayyan", "Cooper", "Declan", "Zain", "Hamza", "Jay", "Adrian", "Lincoln",
    "Chase", "Mustafa", "Fraser", "Danny", "Omar", "Oakley", "Hunter", "Barnaby", "Kye", "Rupert", "Jordan", "Mark", "Preston",
    "Christian", "Tom", "Rohan", "Vinnie", "Rio", "Yahya", "Zakariya", "Jaiden", "Dominik", "Emmanuel", "Rayan", "Zach", "Elias",
    "Grayson", "Lennon", "Sidney", "Raphael", "Eric", "Frank", "Rufus", "Eesa", "Malachi", "Sean", "Francis", "Freddy", "Victor",
    "Zayn", "Wilfred", "Conor", "Shay", "Cian", "Fletcher", "Hassan", "Lenny", "Jan", "Junior", "Robin", "Casey", "Marcel",
    "Rafael", "Aryan", "Arjun", "Josh", "Antoni", "Richard", "Bentley", "Travis", "Ismail", "Fabian", "Phoenix", "Hudson",
    "Martin", "Umar", "Xander", "Josiah", "Isaiah", "Jeremiah", "Aston", "Aarav", "Ahmad", "Euan", "Romeo", "Niall", "Stephen",
    "Brodie", "Jaden", "Mckenzie", "Paul", "Casper", "Harris", "Ashley", "Ayden", "Philip", "Hector", "Julian", "Nicolas", "Sami",
    "Ezra", "Isa", "Simon", "Harri", "Micah", "Timothy", "Tomas", "Caiden", "Szymon", "Brooklyn", "Eddie", "Damian", "Justin",
    "Haris", "Kane", "Tate", "Amir", "Lorenzo", "Cohen", "Leland", "Olivier", "Patryk", "Osian", "Coby", "Leonard", "Bilal", "Enzo",
    "Rex", "Aleksander", "Jimmy", "Zachariah", "Dillon", "Dawid", "Scott", "Marshall", "Nico", "Otis", "Troy", "Angus", "Ibraheem",
    "Amaan", "Kenzie", "Hasan", "Douglas", "Eden", "Solomon", "Zayd", "Franklin", "Ivan", "Rafe", "Hashim", "Khalid", "Mateusz",
    "Dennis", "Keegan", "Benedict", "Finnley", "Jac", "Kaleb", "Parker", "Zane", "Azaan", "Buddy", "Gethin", "Armaan", "Denis",
    "Nate", "Shane", "Cassius", "Maksymilian", "Rylee", "Quinn", "Robbie", "Wyatt", "Jai", "Jaxson", "Luka", "Mitchell", "Aadam",
    "Laurence", "Lawrence", "Lee", "Monty", "Rafferty", "Abel", "Idris", "Ryley", "Barney", "Cayden", "Malakai", "Rudy",
    "Stefan", "Will", "Heath", "Jakob", "Luis", "Montgomery", "Regan", "Steven", "Asher", "Mylo", "Alistair", "Deacon", "Tomos",
    "Brian", "Jax", "Otto", "Anas", "Curtis", "Kylan", "Mikey", "Oliwier", "Archer", "Hugh", "Bertie", "Daniyal", "Ilyas", "Aron",
    "Cai", "Hussain", "Igor", "Ismaeel", "Kyran", "Leyton", "Natan", "Ayman", "Brayden", "Cruz", "Henley", "Jace", "Maison",
    "Matteo", "Milan", "Zayan", "Dean", "Hamish", "Ronan", "Colby", "Dante", "Franciszek", "Hari", "Noel", "Subhan", "Yunus",
    "Drew", "Clayton", "Ernest", "Ezekiel", "Malik", "Nikodem", "Mackenzie", "Yaseen", "Calvin", "Devon", "Dougie", "Lawson",
    "Archibald", "Cory", "Kyron", "Michal", "Tyler-James", "Zakaria", "Zion", "Amari", "Mikolaj", "Yuvraj", "Aydin", "Jonas",
    "Kobi", "Carson", "Edwin", "Georgie", "Kyan", "Woody", "Fergus", "Jago", "Johnny", "Marco", "Wiktor", "Yasin", "Henri", "Kobe",
    "Rehan", "Samson", "Antony", "Bruno", "Farhan", "Ioan", "Kaden", "River", "Teddie", "Bryan", "Haydn", "Rico", "Aayan", "Bartosz",
    "Ciaran", "Shaun", "Caden", "Keaton", "Lloyd", "Maddox", "Braxton", "Imran", "Krish", "Lucian", "Matas", "Nathanael", "Prince"
  )

  private val girlsFirstNames: Set[String] = Set(
    "Amelia", "Olivia", "Emily", "Ava", "Isla", "Jessica", "Poppy", "Isabella", "Sophie", "Mia", "Ruby", "Lily", "Grace", "Evie",
    "Sophia", "Ella", "Scarlett", "Chloe", "Isabelle", "Freya", "Charlotte", "Sienna", "Daisy", "Phoebe", "Millie", "Eva", "Alice",
    "Lucy", "Florence", "Sofia", "Layla", "Lola", "Holly", "Imogen", "Molly", "Matilda", "Lilly", "Rosie", "Elizabeth", "Erin",
    "Maisie", "Lexi", "Ellie", "Hannah", "Evelyn", "Abigail", "Elsie", "Summer", "Megan", "Jasmine", "Maya", "Amelie", "Lacey",
    "Willow", "Emma", "Bella", "Eleanor", "Esme", "Eliza", "Georgia", "Harriet", "Gracie", "Annabelle", "Emilia", "Amber", "Ivy",
    "Brooke", "Rose", "Anna", "Zara", "Leah", "Mollie", "Martha", "Faith", "Hollie", "Amy", "Bethany", "Violet", "Katie", "Maryam",
    "Francesca", "Julia", "Maria", "Darcey", "Isabel", "Tilly", "Maddison", "Victoria", "Isobel", "Niamh", "Skye", "Madison",
    "Darcy", "Aisha", "Beatrice", "Sarah", "Zoe", "Paige", "Heidi", "Lydia", "Sara", "Alexandra", "Darcie", "Lottie", "Eloise",
    "Iris", "Nevaeh", "Lara", "Seren", "Keira", "Nancy", "Annabel", "Fatima", "Caitlin", "Lexie", "Lyla", "Rebecca", "Gabriella",
    "Robyn", "Alexis", "Aaliyah", "Thea", "Mya", "Mila", "Annie", "Lauren", "Libby", "Lena", "Zainab", "Penelope", "Eve",
    "Orla", "Savannah", "Hope", "Maja", "Eden", "Lois", "Nicole", "Clara", "Naomi", "Felicity", "India", "Leila", "Tia", "Laila",
    "Laura", "Natalia", "Sadie", "Alicia", "Connie", "Betsy", "Macie", "Esmae", "Anya", "Anaya", "Lillie", "Arabella", "Esther",
    "Elena", "Harper", "Alyssa", "Aleena", "Alexa", "Edith", "Alisha", "Miley", "Madeleine", "Zahra", "Kayla", "Lucia", "Bonnie",
    "Ayla", "Elise", "Georgina", "Zoya", "Skyla", "Angel", "Beau", "Hanna", "Scarlet", "Zuzanna", "Faye", "Elsa", "Pippa",
    "Emelia", "Ariana", "Maisy", "Myla", "Aimee", "Nina", "Tabitha", "Aoife", "Neve", "Elodie", "Frankie", "Mariam", "Autumn",
    "Amaya", "Amira", "Taylor", "Yasmin", "Amina", "Ayesha", "Khadija", "Rosa", "Inaaya", "Alana", "Alexia", "Khadijah",
    "Jessie", "Safa", "Edie", "Nadia", "Amelia-Rose", "Aria", "Delilah", "Lana", "Lyra", "Lacie", "Ebony", "Lucie", "Abbie",
    "Jemima", "Liliana", "Luna", "Jennifer", "Maggie", "Rachel", "Melissa", "Catherine", "Katherine", "Emilie", "Demi", "Lily-Rose",
    "Olive", "Aiza", "Hafsa", "Polly", "Cara", "Kaitlyn", "Maia", "Emmie", "Macey", "Mary", "Natalie", "Tiana", "Beatrix",
    "Georgie", "Lily-Mae", "April", "Ellie-Mae", "Josie", "Michelle", "Penny", "Talia", "Tallulah", "Arya", "Aurora", "Josephine",
    "Esmee", "Caitlyn", "Melody", "Aminah", "Gabrielle", "Gabriela", "Mabel", "Constance", "Halle", "Syeda", "Ffion", "Lilah",
    "Pearl", "Hallie", "Lilly-May", "Nia", "Dolly", "Eliana", "Honey", "Skylar", "Ada", "Claudia", "Macy", "Oliwia", "Hattie",
    "Inayah", "Vanessa", "Casey", "Inaya", "Maddie", "Destiny", "Lila", "Natasha", "Aliza", "Cerys", "Kiera", "Marnie",
    "Kitty", "Charlie", "Indie", "Hana", "Peyton", "Nikola", "Anastasia", "Louisa", "Zofia", "Courtney", "Fatimah", "Lilly-Rose",
    "Ophelia", "Philippa", "Valentina", "Alicja", "Iqra", "Zaynab", "Aliyah", "Cora", "Sapphire", "Hazel", "Izabella", "Kate",
    "Belle", "Alina", "Arianna", "Evangeline", "Lilly-Mae", "Samantha", "Aurelia", "Carys", "Amara", "Annabella", "Bethan",
    "Ella-Rose", "Kyra", "Ria", "Nicola", "Iyla", "Priya", "Aaminah", "Helena", "Lillian", "Kyla", "Lilia", "Daniella",
    "Tegan", "Ava-Rose", "Imaan", "Nell", "Noor", "Stella", "Amirah", "Chelsea", "Kara", "Antonia", "Ciara", "Halima",
    "Lily-May", "Miriam", "Cleo", "Crystal", "Danielle", "Diana", "Verity", "Annalise", "Ashleigh", "Ellie-May", "Ellen",
    "Louise", "Beth", "Elisa", "Milly", "Minnie", "Tiffany", "Kelsey", "Liberty", "Madeline", "Jade", "Sasha", "Alba",
    "Alesha", "Sydney", "Khloe", "Tianna", "Erica", "Haleema", "Tillie", "Aleksandra", "Isobelle", "Kacey", "Liyana", "Callie",
    "Kiara", "Sabrina", "Hayley", "Jasmin", "Poppie", "Rosalie", "Ana", "Dorothy", "Paris", "Ruth", "Ameera", "Diya",
    "Gracie-Mae", "Lacey-Mae", "Milena", "Leyla", "Wiktoria", "Angelina", "Charley", "Safaa", "Sana", "Serena", "Stephanie",
    "Yusra", "Anayah", "Anika", "Fleur", "Hafsah", "Katelyn", "Siena", "Anabelle", "Harmony", "Jenna", "Kayleigh", "Salma",
    "Alys", "Flora", "Livia", "Nyla", "Maisey", "Tara", "Aya", "Sylvie", "Iona", "Isha", "Katy", "Athena", "Audrey",
    "Harley", "Isla-Rose", "Vivienne", "Joanna", "Manha", "Morgan", "Emmeline", "Laiba", "Malaika", "Mali", "Saskia",
    "Anais", "Bianca", "Blossom", "Genevieve", "Kira", "Mae", "Betty", "Elissa", "Lillie-Mae", "Maizie", "Adriana",
    "Aleeza", "Billie", "Emmy", "Keeley", "Quinn", "Alannah", "Alayna", "Ayana", "Elin", "Frances", "Kimberley", "Mia-Rose",
    "Rubie", "Safiyyah", "Simran", "Bailey", "Ella-Mae", "Jorgie", "Clementine", "Ela", "Hiba", "Jannat", "Nora",
    "Alessia", "Amna", "Daria", "Evie-Mae", "Henrietta", "Iman", "Kaya", "Marwa", "Brooklyn", "Fearne", "Ines", "Lili", "Lola-Rose",
    "Marley", "Piper", "Rhea", "Ariella", "Isra", "Maci", "Saffron"
  )

  private val lastNames: Set[String] = Set(
    "Smith", "Jones", "Williams", "Brown", "Taylor", "Davies", "Wilson", "Evans", "Thomas", "Johnson", "Roberts", "Walker", "Wright",
    "Thompson", "Robinson", "White", "Hughes", "Edwards", "Hall", "Green", "Martin", "Wood", "Lewis", "Harris", "Clarke", "Jackson",
    "Clark", "Turner", "Scott", "Hill", "Moore", "Cooper", "Ward", "Morris", "King", "Watson", "Harrison", "Morgan", "Baker", "Young",
    "Patel", "Allen", "Anderson", "Mitchell", "Phillips", "James", "Campbell", "Bell", "Lee", "Kelly"

  )

  def someFirstName: String = oneOf(boysFirstNames.toList ++ girlsFirstNames.toList)

  def someLastName: String = oneOf(lastNames.toList)

  private def oneOf(values: List[String]): String = Random.shuffle(values).head
}
