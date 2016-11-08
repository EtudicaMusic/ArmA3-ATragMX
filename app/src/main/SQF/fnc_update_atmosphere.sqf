#include "script_component.hpp"

ctrlSetText [200, Str(Round((ATragMX_temperature select ATragMX_currentTarget) * 10) / 10)];
if (ATragMX_currentUnit == 1) then {
	ctrlSetText [210, Str(Round((ATragMX_barometricPressure select ATragMX_currentTarget) * 100) / 100)];
} else {
	ctrlSetText [210, Str(Round(ATragMX_barometricPressure select ATragMX_currentTarget))];
};
ctrlSetText [220, Str(Round((ATragMX_relativeHumidity select ATragMX_currentTarget) * 100 * 10) / 10)];
