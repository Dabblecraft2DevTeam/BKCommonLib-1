package com.bergerkiller.bukkit.common.map;

/**
 * Keeps track of the dirty areas of a canvas
 */
public class MapClip {
    public int dirty_x1, dirty_y1, dirty_x2, dirty_y2;
    public boolean dirty;

    public MapClip() {
        this.dirty_x1 = 0;
        this.dirty_x2 = 0;
        this.dirty_y1 = 0;
        this.dirty_y2 = 0;
        this.dirty = false;
    }

    /**
     * Gets the x-coordinate of the top-left dirty pixel
     * 
     * @return top-left dirty pixel x-coordinate
     */
    public final int getX() {
        return dirty_x1;
    }

    /**
     * Gets the y-coordinate of the top-left dirty pixel
     * 
     * @return top-left dirty pixel y-coordinate
     */
    public final int getY() {
        return dirty_y1;
    }

    /**
     * Gets the width of the dirty area
     * 
     * @return dirty area width
     */
    public final int getWidth() {
        return dirty_x2 - dirty_x1 + 1;
    }

    /**
     * Gets the height of the dirty area
     * 
     * @return dirty area height
     */
    public final int getHeight() {
        return dirty_y2 - dirty_y1 + 1;
    }

    /**
     * Marks a single pixel as dirty
     * 
     * @param x - coordinate of the pixel
     * @param y - coordinate of the pixel
     */
    public final void markDirty(int x, int y) {
        if (!this.dirty) {
            this.dirty = true;
            this.dirty_x1 = this.dirty_x2 = x;
            this.dirty_y1 = this.dirty_y2 = y;
        } else {
            if (x < this.dirty_x1) 
                this.dirty_x1 = x;
            else if (x > this.dirty_x2)
                this.dirty_x2 = x;
            if (y < this.dirty_y1) 
                this.dirty_y1 = y;
            else if (y > this.dirty_y2)
                this.dirty_y2 = y;
        }
    }

    /**
     * Marks a rectangular pixel area dirty
     * 
     * @param x - coordinate of the top-left corner of the rectangle
     * @param y - coordinate of the top-left corner of the rectangle
     * @param w - width of the rectangle
     * @param h - height of the rectangle
     */
    public final void markDirty(int x, int y, int w, int h) {
        int x2 = x + w - 1;
        int y2 = y + h - 1;
        if (!this.dirty) {
            this.dirty = true;
            this.dirty_x1 = x;
            this.dirty_x2 = x2;
            this.dirty_y1 = y;
            this.dirty_y2 = y2;
        } else {
            if (x < this.dirty_x1)
                this.dirty_x1 = x;
            if (y < this.dirty_y1)
                this.dirty_y1 = y;
            if (x2 > this.dirty_x2)
                this.dirty_x2 = x2;
            if (y2 > this.dirty_y2)
                this.dirty_y2 = y2;
        }
    }

    /**
     * Marks a pixel area dirty that is also dirty in another clip
     * 
     * @param clip containing the dirty areas
     */
    public final void markDirty(MapClip clip) {
        if (!this.dirty) {
            this.dirty = true;
            this.dirty_x1 = clip.dirty_x1;
            this.dirty_x2 = clip.dirty_x2;
            this.dirty_y1 = clip.dirty_y1;
            this.dirty_y2 = clip.dirty_y2;
        } else {
            if (clip.dirty_x1 < this.dirty_x1)
                this.dirty_x1 = clip.dirty_x1;
            if (clip.dirty_y1 < this.dirty_y1)
                this.dirty_y1 = clip.dirty_y1;
            if (clip.dirty_x2 > this.dirty_x2)
                this.dirty_x2 = clip.dirty_x2;
            if (clip.dirty_y2 > this.dirty_y2)
                this.dirty_y2 = clip.dirty_y2;
        }
    }
}
