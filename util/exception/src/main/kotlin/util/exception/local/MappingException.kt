package util.exception.local

import util.exception.local.LocalException

class MappingException(override val message: String) : LocalException(message)
