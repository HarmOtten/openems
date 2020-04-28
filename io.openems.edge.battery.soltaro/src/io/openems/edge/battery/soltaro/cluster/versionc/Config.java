package io.openems.edge.battery.soltaro.cluster.versionc;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import io.openems.edge.battery.soltaro.BatteryState;
import io.openems.edge.battery.soltaro.ModuleType;

@ObjectClassDefinition( //
		name = "BMS Soltaro Cluster Version C", //
		description = "Implements the Soltaro multi rack battery system.")
@interface Config {

	@AttributeDefinition(name = "Component-ID", description = "Unique ID of this Component")
	String id() default "bms0";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;

	@AttributeDefinition(name = "Modbus-ID", description = "ID of Modbus brige; ! Soltaro Cluster needs baudrate of 57600 !")
	String modbus_id() default "modbus0";

	@AttributeDefinition(name = "Modbus Unit-ID", description = "The Unit-ID of the Modbus device.")
	int modbusUnitId() default 0;

	@AttributeDefinition(name = "Battery state", description = "Switches the battery into the given state, if default is used, battery state is set automatically")
	BatteryState batteryState() default BatteryState.DEFAULT;

	@AttributeDefinition(name = "Number of slaves", description = "The number of slaves in this battery rack (max. 20)", min = "1", max = "20")
	int numberOfSlaves() default 20;

	@AttributeDefinition(name = "Module type", description = "The type of modules in the rack")
	ModuleType moduleType() default ModuleType.MODULE_3_KWH;

	@AttributeDefinition(name = "Use Rack #1", description = "Is Rack #1 used?")
	boolean isRack1Used() default true;

	@AttributeDefinition(name = "Use Rack #2", description = "Is Rack #1 used?")
	boolean isRack2Used() default true;

	@AttributeDefinition(name = "Use Rack #3", description = "Is Rack #1 used?")
	boolean isRack3Used() default true;

	@AttributeDefinition(name = "Use Rack #4", description = "Is Rack #1 used?")
	boolean isRack4Used() default true;

	@AttributeDefinition(name = "Use Rack #5", description = "Is Rack #1 used?")
	boolean isRack5Used() default true;

	@AttributeDefinition(name = "Error Level 2 Delay", description = "Sets the delay time in seconds how long the system should be stopped after an error level 2 has occurred")
	int errorLevel2Delay() default 600;

	@AttributeDefinition(name = "Max Start Attempts", description = "Sets the counter how many time the system should try to start")
	int maxStartAppempts() default 5;

	@AttributeDefinition(name = "Max Start Time", description = "Max Time in seconds allowed for starting the system")
	int maxStartTime() default 20;

	@AttributeDefinition(name = "Pending Tolerance", description = "time in seconds, that is waited if system status cannot be determinated e.g. in case of reading errors")
	int pendingTolerance() default 15;

	@AttributeDefinition(name = "Start Not Successful Delay Time", description = "Sets the delay time in seconds how long the system should be stopped if it was not able to start")
	int startUnsuccessfulDelay() default 3600;

	@AttributeDefinition(name = "Minimal Cell Voltage Millivolt", description = "Minimal cell voltage in milli volt when system does not allow further discharging")
	int minimalCellVoltage() default 2800;

	@AttributeDefinition(name = "Modbus target filter", description = "This is auto-generated by 'Modbus-ID'.")
	String Modbus_target() default "";

	String webconsole_configurationFactory_nameHint() default "BMS Soltaro Cluster Version C [{id}]";
}