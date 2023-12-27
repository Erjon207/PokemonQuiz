db = db.getSiblingDB('mongodb');

db.createCollection('pokemons');

db.pokemons.insertMany([
    {
        "name": "Pikachu",
        "health": 80,
        "strenght": 30,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Karpador",
        "health": 30,
        "strenght": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Squirtle",
        "health": 40,
        "strenght": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Wartortle",
        "health": 70,
        "strenght": 40,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Blastoise",
        "health": 100,
        "strenght": 80,
        "energy": 3,
        "stage": 3
    },
    {
        "name": "Bulbasaur",
        "health": 40,
        "strenght": 20,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Ivylsaur",
        "health": 60,
        "strenght": 30,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Venusaur",
        "health": 100,
        "strenght": 60,
        "energy": 4,
        "stage": 3
    },
    {
        "name": "Charmander",
        "health": 50,
        "strenght": 20,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Glutexo",
        "health": 90,
        "strenght": 60,
        "energy": 2,
        "stage": 2
    },
    {
        "name": "Charizard",
        "health": 120,
        "strenght": 100,
        "energy": 4,
        "stage": 3
    },
    {
        "name": "Snorlax",
        "health": 120,
        "strenght": 100,
        "energy": 3,
        "stage": 1
    },
    {
        "name": "Eevee",
        "health": 60,
        "strenght": 30,
        "energy": 2,
        "stage": 1
    },
    {
        "name": "Sylveon",
        "health": 110,
        "strenght": 70,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Umbreon",
        "health": 110,
        "strenght": 80,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Jolteon",
        "health": 100,
        "strenght": 160,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Flareon",
        "health": 110,
        "strenght": 120,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Vaporeon",
        "health": 110,
        "strenght": 60,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Glaceon",
        "health": 110,
        "strenght": 120,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Leafeon",
        "health": 110,
        "strenght": 50,
        "energy": 2,
        "stage": 2
    },
    {
        "name": "Espeon",
        "health": 110,
        "strenght": 20,
        "energy": 1,
        "stage": 2
    },
    {
        "name": "Joltik",
        "health": 30,
        "strenght": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Galvantula",
        "health": 90,
        "strenght": 30,
        "energy": 1,
        "stage": 2
    },
    {
        "name": "Raichu",
        "health": 130,
        "strenght": 120,
        "energy": 3,
        "stage": 2
    },
    {
        "name": "Aipom",
        "health": 60,
        "strenght": 10,
        "energy": 1,
        "stage": 1
    },
    {
        "name": "Ambipom",
        "health": 90,
        "strenght": 50,
        "energy": 3,
        "stage": 2
    },
]);