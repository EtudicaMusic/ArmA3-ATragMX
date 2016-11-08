#include "script_component.hpp"

(ATragMX_workingMemory select ATragMX_currentTarget) set [10, (ATragMX_elevationOutput select ATragMX_currentTarget)];
(ATragMX_workingMemory select ATragMX_currentTarget) set [11, (ATragMX_windageOutput select ATragMX_currentTarget)];

call compile preprocessFile ("\atragmx\fnc_update_result.sqf");
