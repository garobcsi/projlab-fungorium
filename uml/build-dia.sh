#!/bin/bash

PNG_DIR="generated_pngs"

ZIP_FILE="plantuml_images.zip"

mkdir -p "$PNG_DIR"

echo "Generating PNG files from PlantUML files..."
for file in *.puml; do
    if [[ -f "$file" ]]; then
        filename=$(basename "$file" .puml)
        plantuml -tpng "$file" -o "$PNG_DIR"
        echo "Generated: $PNG_DIR/$filename.png"
    fi
done

echo "Compressing PNG files into $ZIP_FILE..."
zip -r "$ZIP_FILE" "$PNG_DIR"/*.png

echo "Done! PNG files are compressed into $ZIP_FILE."