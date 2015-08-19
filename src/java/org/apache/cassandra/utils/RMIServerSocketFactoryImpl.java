package org.apache.cassandra.utils;

import java.io.IOException;
import java.net.*;
import java.rmi.server.RMIServerSocketFactory;

import javax.net.ServerSocketFactory;

import org.apache.cassandra.config.DatabaseDescriptor;


public class RMIServerSocketFactoryImpl implements RMIServerSocketFactory
{

    public ServerSocket createServerSocket(final int pPort) throws IOException  {
        //return ServerSocketFactory.getDefault().createServerSocket(pPort, 0, InetAddress.getLoopbackAddress());
        
        //我加上的，避免java.net.BindException
        return ServerSocketFactory.getDefault().createServerSocket(pPort, 0, DatabaseDescriptor.getListenAddress());
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }

        return obj.getClass().equals(getClass());
    }

    public int hashCode()
    {
        return RMIServerSocketFactoryImpl.class.hashCode();
    }
}
