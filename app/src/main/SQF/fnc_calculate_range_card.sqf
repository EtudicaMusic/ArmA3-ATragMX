#include "script_component.hpp"

call compile preprocessFile ("\atragmx\fnc_parse_input.sqf");

private ["_scopeBaseAngle"];
_scopeBaseAngle = ((ATragMX_workingMemory select ATragMX_currentTarget) select 3);

private ["_bulletMass", "_boreHeight", "_airFriction", "_muzzleVelocity", "_bc", "_dragModel", "_atmosphereModel"];
_bulletMass = (ATragMX_workingMemory select ATragMX_currentTarget) select 12;
_boreHeight = (ATragMX_workingMemory select ATragMX_currentTarget) select 5;
_airFriction = (ATragMX_workingMemory select ATragMX_currentTarget) select 4;
_muzzleVelocity = (ATragMX_workingMemory select ATragMX_currentTarget) select 1;
_bc = (ATragMX_workingMemory select ATragMX_currentTarget) select 15;
_dragModel = (ATragMX_workingMemory select ATragMX_currentTarget) select 16;
_atmosphereModel = (ATragMX_workingMemory select ATragMX_currentTarget) select 17;

private ["_temperature", "_barometricPressure", "_relativeHumidity"];
_temperature = (ATragMX_temperature select ATragMX_currentTarget);
_barometricPressure = (ATragMX_barometricPressure select ATragMX_currentTarget);
_relativeHumidity = (ATragMX_relativeHumidity select ATragMX_currentTarget);
if (ATragMX_currentUnit == 1) then
{
	_temperature = (_temperature - 32) / 1.8;
	_barometricPressure = _barometricPressure * 33.8638866667;
};

private ["_windSpeed", "_windDirection", "_inclinationAngle", "_targetSpeed", "_targetRange"];
_windSpeed = (ATragMX_windSpeed select ATragMX_currentTarget);
_windDirection = (ATragMX_windDirection select ATragMX_currentTarget);
_inclinationAngle = (ATragMX_inclinationAngle select ATragMX_currentTarget);
_targetSpeed = (ATragMX_targetSpeed select ATragMX_currentTarget);
_targetRange = ATragMX_rangeCardEndRange;
if (ATragMX_currentUnit != 2) then
{
	_targetRange = _targetRange / 1.0936133;
};
if (ATragMX_currentUnit == 1) then
{
	_windSpeed = _windSpeed / 2.23693629;
	_targetSpeed = _targetSpeed / 2.23693629;
};

ATragMX_rangeCardData = [];

private ["_result"];
_result = [_scopeBaseAngle, _bulletMass, _boreHeight, _airFriction, _muzzleVelocity, _temperature, _barometricPressure, _relativeHumidity, 1000,
			_windSpeed, _windDirection, _inclinationAngle, _targetSpeed, _targetRange, _bc, _dragModel, _atmosphereModel, true] call ATragMX_calcSolution;

