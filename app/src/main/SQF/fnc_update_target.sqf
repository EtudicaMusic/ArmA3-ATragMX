#include "script_component.hpp"

if (!isNil ("ATragMX_windSpeed")) then
{
	ctrlSetText [300, Str(Round((ATragMX_windSpeed select ATragMX_currentTarget) * 100) / 100)];
};
if (!isNil ("ATragMX_windDirection")) then
{
	ctrlSetText [310, Str(Round((ATragMX_windDirection select ATragMX_currentTarget)))];
};
if (!isNil ("ATragMX_inclinationAngle")) then
{
	ctrlSetText [320, Str(Round((ATragMX_inclinationAngle select ATragMX_currentTarget)))];
};
if (!isNil ("ATragMX_targetSpeed")) then
{
	ctrlSetText [330, Str(Round((ATragMX_targetSpeed select ATragMX_currentTarget) * 100) / 100)];
};
if (!isNil ("ATragMX_targetRange")) then
{
	ctrlSetText [340, Str(Round((ATragMX_targetRange select ATragMX_currentTarget)))];
};
