#include "script_component.hpp"

ATragMX_COMPAT_LRF = ["Rangefinder", "Laserdesignator"];

private ["_fnc_atragmx"];

_fnc_atragmx = {
	private ["_target", "_position", "_range", "_inclinationAngle"];
	
	if ((local player) && (currentWeapon player) in ATragMX_COMPAT_LRF && (!isNull (_this select 0))) then {
		_target = getPosATL (_this select 0);
		_position = getPosATL player;
		
		_inclinationAngle = asin((player weaponDirection currentWeapon player) select 2);
		_range = _position distance _target;
		
		ATragMX_inclinationAngle set [ATragMX_currentTarget, _inclinationAngle];
		ATragMX_targetRange set [ATragMX_currentTarget, _range];
	};
};

//["ace_sys_rangefinder_Lazing", _fnc_atragmx] call CBA_fnc_addEventHandler;
