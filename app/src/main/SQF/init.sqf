#include "script_component.hpp"

if (isNil "AdvancedBallistics") then { AdvancedBallistics = false; };
if (isNil "AB_AdvancedAirDragEnabled") then { AB_AdvancedAirDragEnabled = false; };

ATragMX_workingMemory = [+(ATragMX_gunList select 0), +(ATragMX_gunList select 0), +(ATragMX_gunList select 0), +(ATragMX_gunList select 0)];

ATragMX_scopeUnits = ["MILs", "TMOA", "SMOA", "Clicks"];

ATragMX_rangeCardStartRange = 200;
ATragMX_rangeCardEndRange = 2000;
ATragMX_rangeCardIncrement = 50;
ATragMX_rangeCardLastColumns = ["Lead", "RemV", "RemE", "TmFlt"];
ATragMX_rangeCardCurrentColumn = 3;
ATragMX_rangeCardData = [];

ATragMX_rangeAssistTargetSizeUnits = ["in", "ft", "cm", "m"];
ATragMX_rangeAssistTargetSizeUnit = 2;
ATragMX_rangeAssistImageSizeUnits = ["MIL", "TMOA", "IOA"];
ATragMX_rangeAssistImageSizeUnit = 0;
ATragMX_rangeAssistUseTargetHeight = true;

ATragMX_speedAssistNumTicksUnits = ["MIL", "TMOA", "IOA"];
ATragMX_speedAssistNumTicksUnit = 0;
ATragMX_speedAssistTimer = true;

ATragMX_currentUnit = 2;
ATragMX_currentGun = [0, 0, 0, 0];
ATragMX_currentTarget = 0;
ATragMX_currentScopeUnit = [0, 0, 0, 0];

ATragMX_temperature = [15, 15, 15, 15];
ATragMX_barometricPressure = [1013.25, 1013.25, 1013.25, 1013.25];
ATragMX_relativeHumidity = [0.5, 0.5, 0.5, 0.5];

ATragMX_windSpeed = [0, 0, 0, 0];
ATragMX_windDirection = [12, 12, 12, 12];
ATragMX_inclinationAngle = [0, 0, 0, 0];
ATragMX_targetSpeed = [0, 0, 0, 0];
ATragMX_targetRange = [0, 0, 0, 0];

ATragMX_elevationOutput = [0, 0, 0, 0];
ATragMX_windageOutput = [0, 0, 0, 0];
ATragMX_leadOutput = [0, 0, 0, 0];
ATragMX_tofOutput = [0, 0, 0, 0];
ATragMX_velocityOutput = [0, 0, 0, 0];

ATragMX_calcSolution = compile preprocessFile "\atragmx\fnc_calculate_solution.sqf";
