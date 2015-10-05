package AMQPMonitorServ;

import plugincore.PluginEngine;

public class AMQPMonitor implements Runnable {

	private String amqp_server;
	private String amqp_login;
	private String amqp_password;
	private String amqp_outexchange;
	
	//private RabbitMgmtService mgmt;
    
	public AMQPMonitor()
    {
    	this.amqp_server = PluginEngine.config.getConfig("amqp_server");
    	this.amqp_login = PluginEngine.config.getConfig("amqp_server");
    	this.amqp_password = PluginEngine.config.getConfig("amqp_server");
    	this.amqp_outexchange = PluginEngine.config.getConfig("amqp_server");
        //https://github.com/Berico-Technologies/RabbidManagement
    		
    }
	
    public void run() 
	{
		try
		{
			/*
			mgmt =
	    			  RabbitMgmtService.builder()
	    			    .host(amqp_server)
	    			    .port(15672)
	    			    .credentials(amqp_login, amqp_password)
	    			    .build();	
			*/
			
		while (PluginEngine.isActive) 
    	{
			try
			{
				// Get the exchange from the server
				/*
				Optional<Exchange> exBackFromServer = mgmt.exchanges().get(amqp_CHANNEL_NAME);
				String exchange_name = exBackFromServer.get().getName();
				if(!exchange_name.equals(amqp_CHANNEL_NAME))
				{
					String errorString = "Missing Exchange: " + amqp_CHANNEL_NAME + " disabling resource!";
					System.out.println(errorString);
					Launcher.resource_list.put(resource_id, false);
					Launcher.graphDB.setINodeStatus(resource_id, "1", errorString);
					//mark node down
				}
				else
				{
					System.out.println("AMQP Check: Exchange: " + amqp_CHANNEL_NAME + " is Active.");
				}
				Thread.sleep(5000);
				*/
				Thread.sleep(5000);
				
			}
			catch(Exception ex)
			{
				String errorString = "AMQP Check: Exchange: " + amqp_outexchange + " Error: " + ex.toString();
				System.out.println(errorString);
				//PluginEngine.resource_list.put(resource_id, false);
				//PluginEngine.graphDB.setINodeStatus(resource_id, "1", errorString);
				
			}
    	}
		}
		catch(Exception ex)
		{
			System.out.println("AMQPMonitor: " + ex.toString());
		}
	}    
		
}
