db = db.getSiblingDB('mongodb');

db.createCollection('pokemons');
db.createCollection('statistics');

db.pokemons.insertMany([
    {
        "name": "Pikachu",
        "health": 80,
        "strength": 30,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Karpador",
        "health": 30,
        "strength": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Squirtle",
        "health": 40,
        "strength": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Wartortle",
        "health": 70,
        "strength": 40,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Blastoise",
        "health": 100,
        "strength": 80,
        "energy": 3,
        "stage": 3
    },
    {
        "name": "Bulbasaur",
        "health": 40,
        "strength": 20,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Ivylsaur",
        "health": 60,
        "strength": 30,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Venusaur",
        "health": 100,
        "strength": 60,
        "energy": 4,
        "stage": 3
    },
    {
        "name": "Charmander",
        "health": 50,
        "strength": 20,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Glutexo",
        "health": 90,
        "strength": 60,
        "energy": 2,
        "stage": 2
    },
    {
        "name": "Charizard",
        "health": 120,
        "strength": 100,
        "energy": 4,
        "stage": 3
    },
    {
        "name": "Snorlax",
        "health": 120,
        "strength": 100,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Eevee",
        "health": 60,
        "strength": 30,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Sylveon",
        "health": 110,
        "strength": 70,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Umbreon",
        "health": 110,
        "strength": 80,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Jolteon",
        "health": 100,
        "strength": 160,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Flareon",
        "health": 110,
        "strength": 120,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Vaporeon",
        "health": 110,
        "strength": 60,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Glaceon",
        "health": 110,
        "strength": 120,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Leafeon",
        "health": 110,
        "strength": 50,
        "energy": 2,
        "stage": 2
    },
    {
        "name": "Espeon",
        "health": 110,
        "strength": 20,
        "energy": 1,
        "stage": 2
    },
    {
        "name": "Joltik",
        "health": 30,
        "strength": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Galvantula",
        "health": 90,
        "strength": 30,
        "energy": 1,
        "stage": 2
    },
    {
        "name": "Raichu",
        "health": 130,
        "strength": 120,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Aipom",
        "health": 60,
        "strength": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Ambipom",
        "health": 90,
        "strength": 50,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Zekrom",
        "health": 130,
        "strength": 80,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Ho-Oh",
        "health": 130,
        "strength": 120,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Tepig",
        "health": 80,
        "strength": 50,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Tropius",
        "health": 100,
        "strength": 50,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Growlithe",
        "health": 80,
        "strength": 30,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Wimpod",
        "health": 70,
        "strength": 20,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Elekid",
        "health": 30,
        "strength": 30,
        "energy": 0,
        "stage": 1
    },
    {
        "name": "Orthworm",
        "health": 140,
        "strength": 90,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Cufant",
        "health": 100,
        "strength": 80,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Furfrou",
        "health": 90,
        "strength": 20,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Capsakid",
        "health": 60,
        "strength": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Pansage",
        "health": 70,
        "strength": 30,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Charcadet",
        "health": 70,
        "strength": 60,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Tatsugiri",
        "health": 70,
        "strength": 20,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Voltorb",
        "health": 60,
        "strength": 30,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Yamask",
        "health": 70,
        "strength": 30,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Mankey",
        "health": 60,
        "strength": 30,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Shellder",
        "health": 70,
        "strength": 20,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Hoopa",
        "health": 130,
        "strength": 130,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Litwick",
        "health": 50,
        "strength": 0,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Lampent",
        "health": 80,
        "strength": 20,
        "energy": 2,
        "stage": 2
    },
    {
        "name": "Chandelure",
        "health": 120,
        "strength": 80,
        "energy": 2,
        "stage": 3
    },
    {
        "name": "Drifloon",
        "health": 60,
        "strength": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Drifblim",
        "health": 100,
        "strength": 80,
        "energy": 2,
        "stage": 2
    },
    {
        "name": "Ampharaos",
        "health": 140,
        "strength": 80,
        "energy": 3,
        "stage": 3
    },
    {
        "name": "Flaaffy",
        "health": 90,
        "strength": 50,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Mareep",
        "health": 60,
        "strength": 20,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Manectric",
        "health": 90,
        "strength": 40,
        "energy": 2,
        "stage": 2
    },
    {
        "name": "Electrike",
        "health": 60,
        "strength": 20,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Metagross",
        "health": 150,
        "strength": 80,
        "energy": 4,
        "stage": 3
    },
    {
        "name": "Metang",
        "health": 90,
        "strength": 50,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Beldum",
        "health": 60,
        "strength": 30,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Klink",
        "health": 50,
        "strength": 20,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Klang",
        "health": 90,
        "strength": 80,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Klinkklang",
        "health": 160,
        "strength": 130,
        "energy": 3,
        "stage": 3
    },
    {
        "name": "Mienshao",
        "health": 90,
        "strength": 40,
        "energy": 1,
        "stage": 2
    },
    {
        "name": "Mienfoo",
        "health": 60,
        "strength": 30,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Hawlucha",
        "health": 80,
        "strength": 20,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Dratini",
        "health": 50,
        "strength": 20,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Dragonair",
        "health": 80,
        "strength": 60,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Dragonite",
        "health": 150,
        "strength": 80,
        "energy": 3,
        "stage": 3
    }
]);