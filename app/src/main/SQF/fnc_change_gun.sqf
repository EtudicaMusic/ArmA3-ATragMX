#include "script_component.hpp"

if (_this < 0 || _this > (count ATragMX_gunList) - 1) exitWith {};

ATragMX_workingMemory set [ATragMX_currentTarget, +(ATragMX_gunList select _this)];
ATragMX_currentGun set [ATragMX_currentTarget, _this];

lbSetCurSel [6000, (ATragMX_currentGun select ATragMX_currentTarget)];

if ((ATragMX_scopeUnits select (ATragMX_currentScopeUnit select ATragMX_currentTarget)) != "Clicks") then
{
	ATragMX_currentScopeUnit set [ATragMX_currentTarget, (ATragMX_workingMemory select ATragMX_currentTarget) select 6];
};

call compile preprocessFile ("\atragmx\fnc_update_gun.sqf");

ATragMX_elevationOutput set [ATragMX_currentTarget, 0];
ATragMX_windageOutput set [ATragMX_currentTarget, 0];
ATragMX_leadOutput set [ATragMX_currentTarget, 0];
ATragMX_tofOutput set [ATragMX_currentTarget, 0];
ATragMX_velocityOutput set [ATragMX_currentTarget, 0];

call compile preprocessFile ("\atragmx\fnc_update_result.sqf");
