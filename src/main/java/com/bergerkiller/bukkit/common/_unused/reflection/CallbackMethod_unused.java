package com.bergerkiller.bukkit.common._unused.reflection;

import java.util.Map;

/**
 * Represents a Callback that can redirect a method call
 */
public interface CallbackMethod_unused {

    /**
     * Executes this Callback for the instance specified. This instance is the
     * same instance as sent into
     * {@link CallbackSignature_unused#createCallback(Object, Map)}.
     *
     * @param instance to call this Callback on
     * @param args for the Callback to use
     * @return the return type from the Callback
     * @throws Throwable - if anything goes wrong while invoking the Callback
     */
    public Object invoke(Object instance, Object[] args) throws Throwable;
}
