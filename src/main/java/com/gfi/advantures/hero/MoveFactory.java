package com.gfi.advantures.hero;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public final class MoveFactory {
    private static final MoveFactory factory = new MoveFactory();

    private MoveFactory(){}

    public static final MoveFactory getFactory(){
        return factory;
    }

    public Move getMove(char movetype){
        switch (movetype){
            case 'S': return new South();
            case 'N': return new North();
            case 'E': return new East();
            case 'O': return new West();
            default:
                throw new NotImplementedException();
        }
    }
}

