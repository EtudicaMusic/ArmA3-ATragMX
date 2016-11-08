#include "script_component.hpp"

ATragMX_temperature set [ATragMX_currentTarget, parseNumber(ctrlText 200)];
ATragMX_barometricPressure set [ATragMX_currentTarget, 0 max parseNumber(ctrlText 210)];
ATragMX_relativeHumidity set [ATragMX_currentTarget, (0 max parseNumber(ctrlText 220) min 100) / 100];

ATragMX_windSpeed set [ATragMX_currentTarget, 0 max abs(parseNumber(ctrlText 300)) min 50];
ATragMX_windDirection set [ATragMX_currentTarget, 1 max Round(parseNumber(ctrlText 310)) min 12];
ATragMX_inclinationAngle set [ATragMX_currentTarget, -60 max parseNumber(ctrlText 320) min 60];
ATragMX_targetSpeed set [ATragMX_currentTarget, 0 max abs(parseNumber(ctrlText 330)) min 50];
ATragMX_targetRange set [ATragMX_currentTarget, 0 max abs(parseNumber(ctrlText 340)) min 4000];

private ["_boreHeight", "_bulletMass", "_airFriction", "_muzzleVelocity"];
_boreHeight = parseNumber(ctrlText 100);
_bulletMass = parseNumber(ctrlText 110);
if (AdvancedBallistics && AB_AdvancedAirDragEnabled) then {
	_airFriction = 0.1 max parseNumber(ctrlText 120) min 2;
} else {
	_airFriction = parseNumber(ctrlText 120) / -1000;
};
_muzzleVelocity = parseNumber(ctrlText 130);
if (ATragMX_currentUnit == 1) then
{
	_boreHeight = _boreHeight * 2.54;
	_bulletMass = _bulletMass * 0.06479891;
	_muzzleVelocity = _muzzleVelocity / 3.2808399;
};
_boreHeight = 0.1 max _boreHeight min 10;
_bulletMass = 1 max _bulletMass min 100;
_muzzleVelocity = 100 max _muzzleVelocity min 1400;

(ATragMX_workingMemory select ATragMX_currentTarget) set [5, _boreHeight];
(ATragMX_workingMemory select ATragMX_currentTarget) set [12, _bulletMass];
if (AdvancedBallistics && AB_AdvancedAirDragEnabled) then {
	(ATragMX_workingMemory select ATragMX_currentTarget) set [15, _airFriction];
} else {
	(ATragMX_workingMemory select ATragMX_currentTarget) set [4, _airFriction];
};
(ATragMX_workingMemory select ATragMX_currentTarget) set [1, _muzzleVelocity];

private ["_elevationCur", "_elevationCur", "_elevationScopeStep", "_windageScopeStep"];
_elevationCur = parseNumber(ctrlText 402);
_windageCur = parseNumber(ctrlText 412);

switch ((ATragMX_currentScopeUnit select ATragMX_currentTarget)) do
{
    case 0:
    {		
		_elevationCur = _elevationCur * 3.38;
		_windageCur = _windageCur * 3.38;
    };
	
    case 2:
    {		
		_elevationCur = _elevationCur / 1.047;
		_windageCur = _windageCur / 1.047;
    };
	
	case 3:
    {
		_elevationScopeStep = ((ATragMX_workingMemory select ATragMX_currentTarget) select 7);
		_windageScopeStep = ((ATragMX_workingMemory select ATragMX_currentTarget) select 8);
		
		_elevationCur = _elevationCur * _elevationScopeStep;
		_windageCur = _windageCur * _windageScopeStep;
    };
};

(ATragMX_workingMemory select ATragMX_currentTarget) set [10, _elevationCur];
(ATragMX_workingMemory select ATragMX_currentTarget) set [11, _windageCur];

call compile preprocessFile ("\atragmx\fnc_update_gun.sqf");
call compile preprocessFile ("\atragmx\fnc_update_atmosphere.sqf");
call compile preprocessFile ("\atragmx\fnc_update_target.sqf");
