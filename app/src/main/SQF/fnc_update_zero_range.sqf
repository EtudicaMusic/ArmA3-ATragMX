#include "script_component.hpp"

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

private ["_zeroRange"];
_zeroRange = Round(parseNumber(ctrlText 140));
if (ATragMX_currentUnit != 2) then
{
	_zeroRange = _zeroRange / 1.0936133;
};

private ["_temperature", "_barometricPressure", "_relativeHumidity"];
_temperature = (ATragMX_temperature select ATragMX_currentTarget);
_barometricPressure = (ATragMX_barometricPressure select ATragMX_currentTarget);
_relativeHumidity = (ATragMX_relativeHumidity select ATragMX_currentTarget);
if (ATragMX_currentUnit == 1) then
{
	_temperature = (_temperature - 32) / 1.8;
	_barometricPressure = _barometricPressure * 33.8638866667;
};

private ["_result"];
_result = [_scopeBaseAngle, _bulletMass, _boreHeight, _airFriction, _muzzleVelocity, _temperature, _barometricPressure, _relativeHumidity, 1000, 0, 0, 0, 0, _zeroRange, _bc, _dragModel, _atmosphereModel, false] call ATragMX_calcSolution;

(ATragMX_workingMemory select ATragMX_currentTarget) set [2, _zeroRange];
(ATragMX_workingMemory select ATragMX_currentTarget) set [3, _scopeBaseAngle + (_result select 0) / 60];
