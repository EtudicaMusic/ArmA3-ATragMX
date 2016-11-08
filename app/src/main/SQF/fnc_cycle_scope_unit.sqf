#include "script_component.hpp"

call compile preprocessFile ("\atragmx\fnc_parse_input.sqf");

ATragMX_currentScopeUnit set [ATragMX_currentTarget, ((ATragMX_currentScopeUnit select ATragMX_currentTarget) + 1) % (count ATragMX_scopeUnits)];

call compile preprocessFile ("\atragmx\fnc_update_scope_unit.sqf");
call compile preprocessFile ("\atragmx\fnc_update_result.sqf");
