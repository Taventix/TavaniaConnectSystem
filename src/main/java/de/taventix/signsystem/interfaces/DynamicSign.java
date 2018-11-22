package de.taventix.signsystem.interfaces;

import org.bukkit.Location;
import org.bukkit.block.Sign;

public abstract interface DynamicSign {

    public abstract void update();

    public abstract String getID();

    public abstract Sign getSign();

    public abstract String getTarget();

    public abstract Location getLocation();

    public abstract boolean isSignExists();

}
