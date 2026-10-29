# Wild Animals Extreme

A clean Fabric mod for **Minecraft 26.3** powered purely by **GeckoLib**.

Currently adds one animal: the **Jaguar**.

## Features

- Fully animated Jaguar (idle, walk, run, attack)
- Custom Blockbench model + animations
- Custom texture + spawn egg texture
- Spawn egg available in the Spawn Eggs creative tab

Natural spawning will be added later.

## Requirements

- Minecraft 26.3
- Fabric Loader ≥ 0.20.1
- Fabric API
- GeckoLib 5.5.7 (Fabric)

## How to run / develop

1. Open the project in IntelliJ IDEA
2. Let Gradle sync
3. Run the `runClient` task
4. Use the **Jaguar Spawn Egg** or `/summon wild_animals_extreme:jaguar`

## Building

```bash
./gradlew build
```

Jar will appear in `build/libs/`.

## Project Structure

```
src/main/java/com/wildanimalsextreme/
├── WildAnimalsExtreme.java          ← main entrypoint
├── entity/JaguarEntity.java         ← the jaguar + GeckoLib animations
├── client/
│   ├── JaguarModel.java
│   ├── JaguarRenderer.java
│   └── WildAnimalsExtremeClient.java
└── registry/
    ├── ModEntities.java
    └── ModItems.java
```

## Adding more animals later

1. Export new `.geo.json` + `.animation.json` from Blockbench
2. Create a new Entity class that implements `GeoEntity`
3. Register it + renderer + spawn egg

## License

MIT
