package com.gfi.advantures.hero;

import java.util.List;

public class Hero {

    private int line = 0;
    private int column = 0;
    private List<byte[]> map;

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public Hero start(List<byte[]> map) {
        byte[] positions = map.get(0);
        for(int i = 0; i < positions.length ; i++ ){
            if( positions[i] != '#' ){
                this.column = i;
                break;
            }
        }
        this.map = map;
        return this;
    }

    public Hero start(int line, int column) {

        byte[] positions = map.get(line);
        while( positions[column] == '#' ){
            column--;
            if( column == 0) {
                line--;
                column = positions.length -1;
            }
        }
        this.column = column;
        this.line = line;

        return this;
    }

    public Hero move(String moviments) {

        byte[] steps = moviments.getBytes();
        for(int i = 0; i< steps.length; i++) {
            MoveFactory.getFactory()
                    .getMove((char)steps[i])
                    .move(this);

        }

        return this;
    }


    public Hero up() {

        byte[] line_definition = this.map.get(this.line -1);
        if( this.line - 1 >= 0 && line_definition[this.column] != '#' ) this.line --;

        return this;
    }

    public Hero down() {

        byte[] line_definition = this.map.get(this.line +1);
        if( this.line + 1 < this.map.size() && line_definition[this.column] != '#' ) this.line ++;
        return this;
    }

    public Hero right() {

        byte[] line_definition = this.map.get(this.line);
        if(this.column + 1 <= line_definition.length - 1 && line_definition[this.column+1] != '#') this.column++;

        return this;
    }

    public Hero left() {

        byte[] line_definition = this.map.get(this.line);
        if( this.column-1 >= 0 && line_definition[this.column-1] != '#') this.column--;

        return this;
    }

    public String toString() {
        return String.format("(%s,%s)",this.column,this.line);
    }
}
